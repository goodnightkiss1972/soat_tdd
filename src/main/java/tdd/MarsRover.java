package tdd;

public class MarsRover {

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
            y++;
        } else if (orientation.equals(Orientation.W)) {
            x--;
        } else if (orientation.equals(Orientation.S)) {
            y--;
        } else if (orientation.equals(Orientation.E)) {
            if (x == 5) {
                x = 0;
            } else {
                x++;
            }
        }
    }
}

