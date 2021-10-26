package tdd;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @Nested
    class Move {

        @Test
        void forward_when_E() {
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

        @Test
        void forward_when_N() {
            // given
            Integer x = 0;
            Integer y = 0;
            MarsRover marsRover = new MarsRover(x, y, Orientation.N);

            // when
            marsRover.move("f");

            // then
            assertThat(marsRover.getX()).isEqualTo(0);
            assertThat(marsRover.getY()).isEqualTo(1);
        }

        @Test
        void forward_when_W() {
            // given
            Integer x = 0;
            Integer y = 0;
            MarsRover marsRover = new MarsRover(x, y, Orientation.W);

            // when
            marsRover.move("f");

            // then
            assertThat(marsRover.getX()).isEqualTo(-1);
            assertThat(marsRover.getY()).isEqualTo(0);
        }

        @Test
        void forward_when_S() {
            // given
            Integer x = 0;
            Integer y = 0;
            MarsRover marsRover = new MarsRover(x, y, Orientation.S);

            // when
            marsRover.move("f");

            // then
            assertThat(marsRover.getX()).isEqualTo(0);
            assertThat(marsRover.getY()).isEqualTo(-1);
        }
    }

    private static Stream<Orientation> orientaionValues() {
        return Stream.of(Orientation.values());
    }
}