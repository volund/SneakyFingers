package com.example.amos.sneakyfingers;

import android.inputmethodservice.InputMethodService;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.util.Log;

public class SneakyFingersIME extends InputMethodService implements SneakyGestureReceiverListener {
    private View keyboardView;
    private SneakyGestureReceiver leftReceiver;
    private SneakyGestureReceiver rightReceiver;

    @Override
    public View onCreateInputView() {
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
        if (view == leftReceiver)
            source = "Left";
        else
            source = "Right";

        Log.i("SneakyFingers", source + ": " + dir);
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