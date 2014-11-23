package com.example.amos.sneakyfingers;

import android.inputmethodservice.InputMethodService;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Shader.TileMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.TextView;

import android.util.Log;

public class SneakyFingersIME extends InputMethodService implements SneakyGestureReceiverListener {
    private View keyboardView;
    private SneakyGestureReceiver leftReceiver;
    private SneakyGestureReceiver rightReceiver;
    private TextView leftPreview;
    private TextView rightPreview;
    private SneakyLayout gestureLayout = new SneakyLayoutC();

    private boolean shiftEnabled = false;

    @Override
    public View onCreateInputView() {

        keyboardView = getLayoutInflater().inflate(R.layout.sneaky_keyboard, null);

        leftPreview = (TextView)keyboardView.findViewById(R.id.leftPreviewLabel);
        rightPreview = (TextView)keyboardView.findViewById(R.id.rightPreviewLabel);
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
        Direction ls = leftReceiver.motionProcessor.getCurrentSwipeDirection();
        Direction rs = rightReceiver.motionProcessor.getCurrentSwipeDirection();

        if ((ls != Direction.NONE) && (rs != Direction.NONE)) {
            //Log.i("SneakyFingers", "swipe: " + ls + "  |-----|  " + rs);
            InputConnection ic = getCurrentInputConnection();
            Integer key_code = gestureLayout.keyCodeForDirections(ls, rs);
            if ((key_code != null) && (key_code.intValue() != KeyEvent.KEYCODE_UNKNOWN)) {
                /*
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, key_code));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, key_code));
                */
                ic.commitText("?", 1);

            }

            leftReceiver.motionProcessor.reset();
            rightReceiver.motionProcessor.reset();
            shiftEnabled = false;
        }

    }

    @Override
    public void tapped(SneakyGestureReceiver view, long timestamp) {

        InputConnection ic = getCurrentInputConnection();
        if (view == leftReceiver) {
            shiftEnabled = !shiftEnabled;
            ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SHIFT_LEFT));
            ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_SHIFT_RIGHT));
        }
        if (view == rightReceiver) {
            if (shiftEnabled) {
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
            }
            else {
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SPACE));
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_SPACE));
            }
        }
    }

    @Override
    public void swipeChanged(SneakyGestureReceiver view, Direction dir) {
        TextView preview = (view == leftReceiver ? leftPreview : rightPreview);
        if (dir != Direction.NONE) {
         preview.setText(dir.stringSymbol());
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
