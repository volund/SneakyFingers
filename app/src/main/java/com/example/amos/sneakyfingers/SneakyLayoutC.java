package com.example.amos.sneakyfingers;

import android.view.KeyEvent;

import java.util.HashMap;
import java.util.Map;

/**
*
 */
public class SneakyLayoutC implements SneakyLayout {
    private Map<DirectionPair, String> gestureKeyMap = new HashMap<DirectionPair, String>();

    public SneakyLayoutC() {
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP), "e");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP_RIGHT), "p");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.RIGHT), ".");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM_RIGHT), ",");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM), "?");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM_LEFT), "!");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.LEFT), "'");
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP_LEFT), "q");

        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.TOP), "0");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.TOP_RIGHT), "o");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.RIGHT), "1");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.BOTTOM_RIGHT), "2");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.BOTTOM), "3");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.BOTTOM_LEFT), "4");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.LEFT), "m");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.TOP_LEFT), "");

        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP), " ");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP_RIGHT), "c");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.RIGHT), "t");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM_RIGHT), "");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM), "\u0013");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM_LEFT), "");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.LEFT), "d");
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP_LEFT), "y");

        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP), "b");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP_RIGHT), "w");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.RIGHT), ":");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM_RIGHT), "r");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM), "-");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM_LEFT), "s");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.LEFT), "=");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP_LEFT), "");

        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP), "g");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP_RIGHT), "");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.RIGHT), "k");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM_RIGHT), "m");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM), "n");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM_LEFT), "y");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.LEFT), "");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP_LEFT), "");


        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP), "8");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP_RIGHT), "9");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.RIGHT), "x");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM_RIGHT), "v");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM), "5");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM_LEFT), "f");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.LEFT), "6");
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP_LEFT), "7");

        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP), "\u0302");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP_RIGHT), "\u0300");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.RIGHT), "l");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM_RIGHT), "`\u0301");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM), "j");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM_LEFT), "u");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.LEFT), "h");
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP_LEFT), "\u0327");

        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP), "");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP_RIGHT), "i");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.RIGHT), "");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM_RIGHT), "z");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM), "");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM_LEFT), "");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.LEFT), "");
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP_LEFT), "a");
    }

    public String stringForDirections(Direction first, Direction second) {
        String str = gestureKeyMap.get(new DirectionPair(first, second));
        if (str == null)
            return "";

        return str;
    }

}

