package tdd;

public class MarsRover {

    private final Integer y;
    private final Integer x;
    private final String orientaion;

    public MarsRover(Integer x, Integer y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientaion = orientation;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String getOrientation() {
        return orientaion;
    }
}
