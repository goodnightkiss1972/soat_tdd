package tdd;

import org.junit.jupiter.api.Test;

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

    @Test
    void instantiation_initialize_orientation_when_E() {
        // given
        Integer x = 0;
        Integer y = 0;
        String orientation = "E";

        // when
        final MarsRover marsRover = new MarsRover(x, y, orientation);

        // then
        assertThat(marsRover.getOrientation()).isEqualTo(orientation);
    }

    @Test
    void instantiation_initialize_orientation_when_N() {
        // given
        Integer x = 0;
        Integer y = 0;
        String orientation = "N";

        // when
        final MarsRover marsRover = new MarsRover(x, y, orientation);

        // then
        assertThat(marsRover.getOrientation()).isEqualTo(orientation);
    }
}