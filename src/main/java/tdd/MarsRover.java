package tdd;

public class MarsRover {

    private final Integer y;
    private final Integer x;
    private final Orientation orientation;

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
}
