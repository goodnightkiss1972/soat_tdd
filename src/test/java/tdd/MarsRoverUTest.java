package tdd;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverUTest {

    @Nested
    static class Constructor {
        @Test
        void instantiation_initialize_position_when_0_0() {
            // given
            Integer x = 0;
            Integer y = 0;

            // when
            final MarsRover marsRover = new MarsRover(x, y, null);

            // then
            assertThat(marsRover.getX()).isEqualTo(0);
            assertThat(marsRover.getY()).isEqualTo(0);
        }

        @Test
        void instantiation_initialize_position_when_1_2() {
            // given
            Integer x = 1;
            Integer y = 2;

            // when
            final MarsRover marsRover = new MarsRover(x, y, null);

            // then
            assertThat(marsRover.getX()).isEqualTo(1);
            assertThat(marsRover.getY()).isEqualTo(2);
        }

        @ParameterizedTest
        @MethodSource("orientaionValues")
        void instantiation_initialize_orientation_when(Orientation orientation) {
            // given
            Integer x = 0;
            Integer y = 0;

            // when
            final MarsRover marsRover = new MarsRover(x, y, orientation);

            // then
            assertThat(marsRover.getOrientation()).isEqualTo(orientation);
        }
    }

    @ParameterizedTest
    @MethodSource("forwardArgs")
    void forward(Orientation orientation, Integer oldX, Integer oldY, Integer newX, Integer newY) {
        // given
        Integer x = oldX;
        Integer y = oldY;
        MarsRover marsRover = new MarsRover(x, y, orientation);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(newX);
        assertThat(marsRover.getY()).isEqualTo(newY);
    }


    private static Stream<Orientation> orientaionValues() {
        return Stream.of(Orientation.values());
    }

    private static Stream<Arguments> forwardArgs() {
        return Stream.of(
                Arguments.of(Orientation.E, 0, 0, 1, 0),
                Arguments.of(Orientation.N, 0, 0, 0, 1),
                Arguments.of(Orientation.W, 0, 0, -1, 0),
                Arguments.of(Orientation.S, 0, 0, 0, -1)
        );
    }
}