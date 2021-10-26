package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverUTest {

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

    @Test
    void forward() {
        // given
        Integer x = 0;
        Integer y = 0;
        MarsRover marsRover = new MarsRover(x, y, Orientation.E);

        // when
        marsRover.move("f");

        // then
        assertThat(marsRover.getX()).isEqualTo(1);
        assertThat(marsRover.getY()).isEqualTo(0);
    }


    private static Stream<Orientation> orientaionValues() {
        return Stream.of(Orientation.values());
    }
}