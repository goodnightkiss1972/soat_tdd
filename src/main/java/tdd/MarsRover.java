package tdd;

public class MarsRover {

    public static final int PLANET_BORDER = 5;

    private Integer y;
    private Integer x;
    private Orientation orientation;
    private final Detector detector;

    public MarsRover(Integer x, Integer y, Orientation orientation, Detector detector) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.detector = detector;
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
        if (detector.probe()) {
            return;
        }
        if (orientation.equals(Orientation.N)) {
            moveNorth();
        } else if (orientation.equals(Orientation.W)) {
            moveWest();
        } else if (orientation.equals(Orientation.S)) {
            moveSouth();
        } else if (orientation.equals(Orientation.E)) {
            moveEast();
        }
    }

    private void moveSouth() {
        if (y == 0) {
            y = PLANET_BORDER;
        } else {
            y--;
        }
    }

    private void moveWest() {
        if (x == 0) {
            x = PLANET_BORDER;
        } else  {
            x--;
        }
    }

    private void moveEast() {
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

