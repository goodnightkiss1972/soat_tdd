package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MarsRoverUTest {

    private Detector detector;

    @BeforeEach
    void setUp() {
        detector = mock(Detector.class);
    }

    @Test
    void when_no_obstacle_constructor_instantiation_initialize_position_when_0_0() {
        // given
        Integer x = 0;
        Integer y = 0;

        // when
        final MarsRover marsRover = new MarsRover(x, y, null, detector);

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
    }

    @Test
    void when_no_obstacle_constructor_instantiation_initialize_position_when_1_2() {
        // given
        Integer x = 1;
        Integer y = 2;

        // when
        final MarsRover marsRover = new MarsRover(x, y, null, detector);

        // then
        assertThat(marsRover.getX()).isEqualTo(1);
        assertThat(marsRover.getY()).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("orientationValues")
    void when_no_obstacle_constructor_instantiation_initialize_orientation_when(Orientation orientation) {
        // given
        Integer x = 0;
        Integer y = 0;

        // when
        final MarsRover marsRover = new MarsRover(x, y, orientation, detector);

        // then
        assertThat(marsRover.getOrientation()).isEqualTo(orientation);
    }

    @ParameterizedTest
    @MethodSource("forwardArgs")
    void when_no_obstacle_forward(Orientation orientation, Integer oldX, Integer oldY, Integer newX, Integer newY) {
        // given
        Integer x = oldX;
        Integer y = oldY;
        MarsRover marsRover = new MarsRover(x, y, orientation, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(newX);
        assertThat(marsRover.getY()).isEqualTo(newY);
    }

    private static Stream<Orientation> orientationValues() {
        return Stream.of(Orientation.values());
    }

    private static Stream<Arguments> forwardArgs() {
        return Stream.of(
                Arguments.of(Orientation.E, 0, 0, 1, 0),
                Arguments.of(Orientation.N, 0, 0, 0, 1),
                Arguments.of(Orientation.W, 0, 0, 5, 0),
                Arguments.of(Orientation.S, 0, 0, 0, 5)
        );
    }

    @Test
    void when_no_obstacle_forward_when_extreme_E() {
        // given
        Integer x = 5;
        Integer y = 0;
        MarsRover marsRover = new MarsRover(x, y, Orientation.E, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
    }

    @Test
    void when_no_obstacle_forward_when_extreme_N() {
        // given
        Integer x = 0;
        Integer y = 5;
        MarsRover marsRover = new MarsRover(x, y, Orientation.N, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
    }

    @Test
    void when_no_obstacle_forward_when_extreme_W() {
        // given
        Integer x = 0;
        Integer y = 0;
        MarsRover marsRover = new MarsRover(x, y, Orientation.W, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(5);
        assertThat(marsRover.getY()).isEqualTo(0);
    }

    @Test
    void when_no_obstacle_forward_when_extreme_S() {
        // given
        Integer x = 0;
        Integer y = 0;
        MarsRover marsRover = new MarsRover(x, y, Orientation.S, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(5);
    }

    @Test
    void when_obstacle_forward_when_extreme_E_using_mock() {
        // given
        Integer x = 0;
        Integer y = 0;
        when(detector.probe()).thenReturn(true);
        MarsRover marsRover = new MarsRover(x, y, Orientation.E, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
    }

    @Test
    void when_obstacle_forward_when_extreme_E_fake_implementation() {
        // given
        Integer x = 0;
        Integer y = 0;
        detector = new FakeStaticDetector(true);
        MarsRover marsRover = new MarsRover(x, y, Orientation.E, detector);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
    }

    private class FakeStaticDetector implements Detector {
        private final boolean isObstacleDetected;

        public FakeStaticDetector(boolean isObstacleDetected) {
            this.isObstacleDetected = isObstacleDetected;
        }

        @Override
        public Boolean probe() {
            return isObstacleDetected;
        }
    }
}