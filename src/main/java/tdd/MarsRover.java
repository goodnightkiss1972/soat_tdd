package tdd;

public class MarsRover {

    public static final int PLANET_BORDER = 5;
    private Integer y;
    private Integer x;
    private Orientation orientation;

    public MarsRover(Integer x, Integer y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void move(String command) {
        if (orientation.equals(Orientation.N)) {
            moveNorth();
        } else if (orientation.equals(Orientation.W)) {
            x--;
        } else if (orientation.equals(Orientation.S)) {
            y--;
        } else if (orientation.equals(Orientation.E)) {
            moveEst();
        }
    }

    private void moveEst() {
        if (x == PLANET_BORDER) {
            x = 0;
        } else {
            x++;
        }
    }

    private void moveNorth() {
        if (y == PLANET_BORDER) {
            y = 0;
        } else {
            y++;
        }
    }
}

