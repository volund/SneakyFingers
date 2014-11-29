package com.example.amos.sneakyfingers;

import android.view.MotionEvent;
import android.util.Log;

/**
 *
 */
public class MotionProcessorMod implements MotionProcessor{
    static int blockHeight = 55;
    static int blockWidth = 73;

    int verticalCenterPadding = 10;
    int horizontalCenterPadding = 10;

    Block lastBlock = new Block(-1, -1);
    Block currentBlock = new Block(-1, -1);

    public void processMotionEvent(MotionEvent event) {
        Point pt = new Point(event.getX(0), event.getY(0));

        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            reset();
        }
        else {
            boolean is_down = (event.getActionMasked() == MotionEvent.ACTION_DOWN);
            processPoint(pt, is_down);
        }
    }

    public void processPoint(Point pt, boolean is_down) {
        int vertical_displacement = (int)Math.floor(pt.y % blockHeight);
        int horizontal_displacement = (int)Math.floor(pt.x % blockWidth);

        boolean is_vertical_center = ((vertical_displacement > verticalCenterPadding) &&
                                      (vertical_displacement < blockHeight - verticalCenterPadding));
        boolean is_horizontal_center = ((horizontal_displacement > horizontalCenterPadding) &&
                                        (horizontal_displacement < blockWidth - horizontalCenterPadding));
        boolean is_center = is_vertical_center && is_horizontal_center;


        Block newBlock = new Block(pt);
        if (lastBlock.isTrivial() && currentBlock.isTrivial()) {
            lastBlock = currentBlock;
            currentBlock = newBlock;
        }
        else if (is_center && !newBlock.equals(currentBlock)) {
            lastBlock = currentBlock;
            currentBlock = newBlock;
            //Log.i("SneakyFingers", "last/current/new" + lastBlock + " / " + currentBlock + " / " + newBlock);
            Log.i("SneakyFingers", "last/current" + lastBlock + " / " + currentBlock);

        }


    }

    public boolean hasNewSwipeDirection() {
        return false;
    }

    public boolean shouldTrigger() {
        if (currentBlock.isTrivial() || lastBlock.isTrivial())
            return false;

        return !currentBlock.equals(lastBlock);
    }

    public Direction getCurrentSwipeDirection() {
        if (currentBlock.isTrivial() || lastBlock.isTrivial()) {
            Log.e("SneakyFingers", "ERROR: found trivial blocks during swipe direction");
            return Direction.NONE;
        }

        return currentBlock.directionFromBlock(lastBlock);
    }

    private class Block {
        public int h_index;
        public int v_index;

        public Block(int hi, int vi) {
            h_index = hi;
            v_index = vi;
        }

        public Block(Point pt) {
            h_index = (int)Math.floor(pt.x / MotionProcessorMod.blockWidth);
            v_index = (int)Math.floor(pt.y / MotionProcessorMod.blockHeight);
        }

        public boolean isTrivial() {
            return (h_index == -1) && (v_index == -1);
        }

        public boolean equals(Object obj) {
            //null instanceof Object will always return false
            if (!(obj instanceof Block))
                return false;
            if (obj == this)
                return true;
            return  (this.h_index == ((Block) obj).h_index) &&
                    (this.v_index == ((Block) obj).v_index);
        }

        public int hashCode() {
            return this.h_index + this.v_index * 100;
        }
        public Direction directionFromBlock(Block other) {
            int dh = this.h_index - other.h_index;
            int dv = this.v_index - other.v_index;

            if ((dh == 0) && (dv < 0))
                return Direction.TOP;
            else if ((dh > 0) && (dv < 0))
                return Direction.TOP_RIGHT;
            else if ((dh > 0) && (dv == 0))
                return Direction.RIGHT;
            else if ((dh > 0) && (dv > 0))
                return Direction.BOTTOM_RIGHT;
            else if ((dh == 0) && (dv > 0))
                return Direction.BOTTOM;
            else if ((dh < 0) && (dv > 0))
                return Direction.BOTTOM_LEFT;
            else if ((dh < 0) && (dv == 0))
                return Direction.LEFT;
            else if ((dh < 0) && (dv < 0))
                return Direction.TOP_LEFT;

            return Direction.NONE; // (dh == 0) && (dv == 0)
        }

        public String toString() {
            return "[Block (" + h_index + ", " + v_index + ")]";
        }
    }

    public void reset() {
        Log.i("SneakyFingres", "reset...");
        lastBlock = new Block(-1, -1);
        currentBlock = new Block(-1, -1);
    }
}
