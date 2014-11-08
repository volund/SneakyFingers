package com.example.amos.sneakyfingers;

import java.util.ArrayList;

import android.view.MotionEvent;
import android.util.Log;

/**
 *
 */
public class MotionProcessorSimpleAverage {

    static final int POINT_LIST_SIZE = 11;

    public ArrayList<Point> points = new ArrayList<Point>();
    public ArrayList<Point> deltas = new ArrayList<Point>();
    public ArrayList<Direction> delta_regions = new ArrayList<Direction>();
    public Direction currentSwipeDirection = Direction.NONE;
    public Direction previousSwipeDirection = Direction.NONE;
    public double distance = 0;

    public void processMotionEvent(MotionEvent event) {
        Point pt = new Point(event.getX(0), event.getY(0));
        processPoint(pt);
    }

    public void processPoint(Point pt) {
        pushPoint(pt);
        previousSwipeDirection = currentSwipeDirection;
        currentSwipeDirection = determineDirection();
    }

    public Direction determineDirection() {
        if (!pointsArrayIsFull()) {
            return Direction.NONE;
        }

        Direction direction = delta_regions.get(0);
        int tolerance = 3;
        for (Direction candidate : delta_regions) {
            if (candidate != direction)
                tolerance -= 1;
            if (tolerance != 0)
                continue;
            direction = Direction.NONE;
            break;
        }

        return direction;
    }

    public boolean hasNewSwipeDirection() {
        return (currentSwipeDirection != previousSwipeDirection);
    }


    public void pushPoint(Point pt) {
        points.add(pt);

        int size = points.size();
        if (size > 1) {
            Point prev_pt = points.get(size - 2);
            Point delta = prev_pt.subtractFrom(pt);
            distance += delta.length();
            deltas.add(delta);
            delta_regions.add(delta.region());
;        }

        if (points.size() > POINT_LIST_SIZE) {
            points.remove(0);
            deltas.remove(0);
            delta_regions.remove(0);
        }
    }

    public boolean pointsArrayIsFull() {
        return (points.size() >= POINT_LIST_SIZE);
    }

    public void emptyPointsArray() {
        points.clear();
        deltas.clear();
        delta_regions.clear();
    }

    public void reset() {
        Log.i("SneakyFingers", "resetting...");
        emptyPointsArray();
        distance = 0;
    }

}
