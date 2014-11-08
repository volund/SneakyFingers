package com.example.amos.sneakyfingers;

import android.inputmethodservice.InputMethodService;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.util.Log;
import java.util.Map;
import java.util.HashMap;

public class SneakyFingersIME extends InputMethodService implements SneakyGestureReceiverListener {
    private View keyboardView;
    private SneakyGestureReceiver leftReceiver;
    private SneakyGestureReceiver rightReceiver;
    /*
    private Direction leftSwipeDirection;
    private Direction rightSwipeDirection;*/
    private Map<DirectionPair, Integer> gestureKeyMap = new HashMap<DirectionPair, Integer>();

    @Override
    public View onCreateInputView() {
        defineDestureKeyMap();

        keyboardView = getLayoutInflater().inflate(R.layout.sneaky_keyboard, null);

        leftReceiver = (SneakyGestureReceiver)keyboardView.findViewById(R.id.leftrcv);
        rightReceiver = (SneakyGestureReceiver)keyboardView.findViewById(R.id.rightrcv);

        leftReceiver.listener = this;
        rightReceiver.listener = this;

        Button inputMethodsButton = (Button)keyboardView.findViewById(R.id.change_input_methods);

        inputMethodsButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                InputMethodManager imeManager = (InputMethodManager) arg0.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imeManager != null) {
                    imeManager.showInputMethodPicker();
                } else {
                    //Toast.makeText(context ,"Error", Toast.LENGTH_LONG).show();
                }
            }});

        return keyboardView;
    }


    @Override
    public void trigger() {
        Direction ls = leftReceiver.motionProcessor.currentSwipeDirection;
        Direction rs = rightReceiver.motionProcessor.currentSwipeDirection;

        if ((ls != Direction.NONE) && (rs != Direction.NONE)) {
            Log.i("SneakyFingers", "swipe: " + ls + "  |-----|  " + rs);
            InputConnection ic = getCurrentInputConnection();
            DirectionPair combination = new DirectionPair(ls, rs);
            Integer key_code = gestureKeyMap.get(combination);
            if ((key_code != null) && (key_code.intValue() != KeyEvent.KEYCODE_UNKNOWN)) {
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, key_code));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, key_code));

            }

            leftReceiver.motionProcessor.reset();
            rightReceiver.motionProcessor.reset();
        }

    }

    @Override
    public void swipeChanged(SneakyGestureReceiver view, Direction dir) {
    }
        /*

        String source;
        if (view == leftReceiver) {
            leftSwipeDirection = dir;
            source = "Left";
        } else {
            rightSwipeDirection = dir;
            source = "Right";
        }

        if ((leftSwipeDirection != Direction.NONE) && (rightSwipeDirection != Direction.NONE)) {
            Log.i("SneakyFingers", "swipe: " + leftSwipeDirection + "  |-----|  " + rightSwipeDirection);
            InputConnection ic = getCurrentInputConnection();
            DirectionPair combination = new DirectionPair(leftSwipeDirection, rightSwipeDirection);
            Log.i("SneakyFingers", "gestureKeyMap: " + gestureKeyMap);
            Integer key_code = gestureKeyMap.get(combination);
            if ((key_code != null) && (key_code.intValue() != KeyEvent.KEYCODE_UNKNOWN)) {
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, key_code));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, key_code));

                rightReceiver.motionProcessor.reset();
                leftReceiver.motionProcessor.reset();

            }
        }

    }*/

    void defineDestureKeyMap() {
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

    static class DirectionPair {
        public Direction first = Direction.NONE;
        public Direction second = Direction.NONE;

        DirectionPair(Direction d1, Direction d2) {
            first = d1;
            second = d2;
        }

        public boolean equals(Object obj) {
            //null instanceof Object will always return false
            if (!(obj instanceof DirectionPair))
                return false;
            if (obj == this)
                return true;
            return  (this.first == ((DirectionPair) obj).first) &&
                    (this.second == ((DirectionPair) obj).second);
        }

        public int hashCode() {
            int code = 0;
            if (first != null)
                code += first.intCode() * 10;
            if (second != null)
                code += second.intCode();
            return code;
        }
    }
}

/*
public class SneakyFingersIME extends Service {
    public SneakyFingersIME() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
*/
