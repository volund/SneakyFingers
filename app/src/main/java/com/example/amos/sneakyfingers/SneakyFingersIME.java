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
    private Direction leftSwipeDirection;
    private Direction rightSwipeDirection;
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
    public void swipeChanged(SneakyGestureReceiver view, Direction dir) {
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
            if (((leftSwipeDirection == Direction.BOTTOM_LEFT) && (rightSwipeDirection == Direction.BOTTOM_LEFT)) ||
                    ((leftSwipeDirection == Direction.TOP_RIGHT) && (rightSwipeDirection == Direction.TOP_RIGHT))) {
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
            }
            else {
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_A));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_A));
            }
        }

    }

    void defineDestureKeyMap() {
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);

        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.RIGHT, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);

        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_RIGHT, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);


        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);


        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.BOTTOM_LEFT, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);

        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.LEFT, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);

        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM_RIGHT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.BOTTOM_LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.LEFT), KeyEvent.KEYCODE_E);
        gestureKeyMap.put(new DirectionPair(Direction.TOP_LEFT, Direction.TOP_LEFT), KeyEvent.KEYCODE_E);
    }

    static class DirectionPair {
        public Direction first = Direction.NONE;
        public Direction second = Direction.NONE;

        DirectionPair(Direction d1, Direction d2) {
            first = d1;
            second = d2;
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
