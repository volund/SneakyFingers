package com.example.amos.sneakyfingers;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.inputmethodservice.InputMethodService;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.util.Log;

public class SneakyFingersIME extends InputMethodService {
    private View keyboardView;

    @Override
    public View onCreateInputView() {
        keyboardView = getLayoutInflater().inflate(R.layout.sneaky_keyboard, null);

        SneakyGestureReceiver leftrcv = (SneakyGestureReceiver)keyboardView.findViewById(R.id.leftrcv);
        SneakyGestureReceiver rightrcv = (SneakyGestureReceiver)keyboardView.findViewById(R.id.rightrcv);
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

        leftrcv.setOnGestureRecognizedListener(new OnGestureRecognizedListener() {
            @Override
            public void gestureRecognized(String gesture) {
                //enterCharacter(character);
                Log.i("SFK", "got " + gesture);
            }
        });
        rightrcv.setOnGestureRecognizedListener(new OnGestureRecognizedListener() {
            @Override
            public void gestureRecognized(String gesture) {
                //enterCharacter(character);
                Log.i("SFK", "got " + gesture);
            }
        });
        return keyboardView;
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