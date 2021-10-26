package tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverUTest {


    @Test
    void constructor_bind_position() {
        // given
        Integer x = 0;
        Integer y = 0;

        // when
        final MarsRover marsRover = new MarsRover(x, y);

        // then
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
    }
}