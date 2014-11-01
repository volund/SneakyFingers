package com.example.amos.sneakyfingers;

/**
 * Created by amos on 01/11/14.
 */
public class Point {

    Point(double xval, double yval) {
        x = xval;
        y = yval;
    }

    Point subtractFrom(Point other) {
        return new Point(other.x - x, other.y - y);
    }

    public Direction region() {
        if (x == 0)
            return (y <= 0 ? Direction.TOP : Direction.BOTTOM);

        double slope = y/x;
        if (x > 0) {
            if (slope < -2.0)
                return Direction.TOP;
            else if (slope < -0.5)
                return Direction.TOP_RIGHT;
            else if (slope < 0.5)
                return Direction.RIGHT;
            else if (slope  < 2.0)
                return Direction.BOTTOM_RIGHT;
            else
                return Direction.BOTTOM;
        }
        else {
            if (slope > 2.0)
                return Direction.TOP;
            else if (slope > 0.5)
                return Direction.TOP_LEFT;
            else if (slope > -0.5)
                return Direction.LEFT;
            else if (slope > -2.0)
                return Direction.BOTTOM_LEFT;
            else
                return Direction.BOTTOM;
        }

    }

    @Override
    public String toString(){
        return "<Point (" + x + ", " + y + ")>";
    }
    public double x;
    public double y;
}