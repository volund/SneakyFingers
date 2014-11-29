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
    private Button inputMethodsButton;
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

        inputMethodsButton = (Button)keyboardView.findViewById(R.id.change_input_methods);

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


        updateShiftStatus();
        return keyboardView;
    }

    @Override
    public void trigger() {
        Direction ls = leftReceiver.motionProcessor.getCurrentSwipeDirection();
        Direction rs = rightReceiver.motionProcessor.getCurrentSwipeDirection();

        if ((ls != Direction.NONE) && (rs != Direction.NONE)) {
            //Log.i("SneakyFingers", "swipe: " + ls + "  |-----|  " + rs);
            InputConnection ic = getCurrentInputConnection();
            String str = gestureLayout.stringForDirections(ls, rs);
            if (shiftEnabled)
                str = str.toUpperCase();
            if (!str.equals("")) {
                ic.commitText(str, 1);
            }

            leftReceiver.motionProcessor.reset();
            rightReceiver.motionProcessor.reset();
            shiftEnabled = false;
        }
        updateShiftStatus();
    }

    @Override
    public void tapped(SneakyGestureReceiver view, long timestamp) {
        Log.i("SneakyFingers", "tapped");

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
        updateShiftStatus();
    }

    @Override
    public void swipeChanged(SneakyGestureReceiver view, Direction dir) {
        TextView preview = (view == leftReceiver ? leftPreview : rightPreview);
        if (dir != Direction.NONE) {
         preview.setText(dir.stringSymbol());
        }

    }

    void updateShiftStatus() {
        if (shiftEnabled)
            inputMethodsButton.setText("+");
        else
            inputMethodsButton.setText("x");
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
