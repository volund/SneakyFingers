package com.example.amos.sneakyfingers;

/**
 * Created by amos on 01/11/14.
 */
public enum Direction {
    TOP, BOTTOM, LEFT, RIGHT, TOP_RIGHT, TOP_LEFT, BOTTOM_RIGHT, BOTTOM_LEFT, NONE;

    public int intCode() {
        int code = 0;

        switch (this) {
            case NONE: code = 0; break;
            case TOP: code = 1; break;
            case BOTTOM: code = 2; break;
            case LEFT: code = 3; break;
            case RIGHT: code = 4; break;
            case TOP_RIGHT: code = 5; break;
            case TOP_LEFT: code = 6; break;
            case BOTTOM_RIGHT: code = 7; break;
            case BOTTOM_LEFT: code = 8; break;
        }

        return code;
    }
}
