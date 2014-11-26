package com.example.amos.sneakyfingers;

import java.util.Map;
import java.util.HashMap;
import android.view.KeyEvent;

/**
 *
 */
public class SneakyLayoutA implements SneakyLayout {
    private Map<DirectionPair, Integer> gestureKeyMap = new HashMap<DirectionPair, Integer>();

    public SneakyLayoutA() {
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP_RIGHT), KeyEvent.KEYCODE_M);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.RIGHT), KeyEvent.KEYCODE_0);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_1);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM), KeyEvent.KEYCODE_2);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_3);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.LEFT), KeyEvent.KEYCODE_4);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP_LEFT), KeyEvent.KEYCODE_Q);

        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.TOP), KeyEvent.KEYCODE_K);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_O);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.RIGHT), KeyEvent.KEYCODE_5);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_6);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.BOTTOM), KeyEvent.KEYCODE_7);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_8);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.LEFT), KeyEvent.KEYCODE_9);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_RIGHT, Direction.TOP_LEFT), KeyEvent.KEYCODE_F);

        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP), KeyEvent.KEYCODE_SPACE);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_C);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.RIGHT), KeyEvent.KEYCODE_T);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_V);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM), KeyEvent.KEYCODE_ENTER);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.LEFT), KeyEvent.KEYCODE_DEL);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP_LEFT), KeyEvent.KEYCODE_X);

        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP), KeyEvent.KEYCODE_LEFT_BRACKET);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_J);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.RIGHT), KeyEvent.KEYCODE_RIGHT_BRACKET);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_S);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.LEFT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP_LEFT), KeyEvent.KEYCODE_P);


        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP), KeyEvent.KEYCODE_G);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP_RIGHT), KeyEvent.KEYCODE_APOSTROPHE);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.RIGHT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_L);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM), KeyEvent.KEYCODE_N);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_D);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.LEFT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP_LEFT), KeyEvent.KEYCODE_UNKNOWN);


        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_Z);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.RIGHT), KeyEvent.KEYCODE_W);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_R);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM), KeyEvent.KEYCODE_PERIOD);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_COMMA);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.LEFT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP_LEFT), KeyEvent.KEYCODE_UNKNOWN);

        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP), KeyEvent.KEYCODE_PLUS);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.RIGHT), KeyEvent.KEYCODE_DEL);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_EQUALS);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM), KeyEvent.KEYCODE_Y);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_U);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.LEFT), KeyEvent.KEYCODE_H);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP_LEFT), KeyEvent.KEYCODE_UNKNOWN);

        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_I);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.RIGHT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_UNKNOWN);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.LEFT), KeyEvent.KEYCODE_B);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP_LEFT), KeyEvent.KEYCODE_A);
    }

    public int keyCodeForDirections(Direction first, Direction second) {
        Integer key_code = gestureKeyMap.get(new DirectionPair(first, second));
        if (key_code == null)
            return KeyEvent.KEYCODE_UNKNOWN;

        return key_code.intValue();
    }

    public String stringForDirections(Direction first, Direction second) {
        return "?";
    }

}
