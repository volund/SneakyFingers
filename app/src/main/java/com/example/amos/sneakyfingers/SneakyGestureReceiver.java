package com.example.amos.sneakyfingers;

import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.GestureLibrary;
import android.gesture.GestureLibraries;
import android.gesture.Gesture;
import android.gesture.Prediction;

import android.content.Context;
import android.util.AttributeSet;

import java.util.List;


public class SneakyGestureReceiver extends GestureOverlayView implements OnGesturePerformedListener  {
    private final static double SCORE_TRESHOLD = 3.0;
    private final GestureLibrary mGestureLibrary;
    private OnGestureRecognizedListener mOnGestureRecognizedListener;

    public SneakyGestureReceiver(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureLibrary = GestureLibraries.fromRawResource(context, R.raw.gestures);
        mGestureLibrary.load();
        addOnGesturePerformedListener(this);
    }

    public void setOnGestureRecognizedListener(OnGestureRecognizedListener onGestureRecognizedListener) {
        mOnGestureRecognizedListener = onGestureRecognizedListener;
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        List<Prediction> predictions = mGestureLibrary.recognize(gesture);
        Prediction bestPrediction = null;
        if (predictions.size() > 0) {
            bestPrediction = predictions.get(0);
        }
        if (mOnGestureRecognizedListener != null && bestPrediction != null) {
            if (bestPrediction.score > SCORE_TRESHOLD) {
                mOnGestureRecognizedListener.gestureRecognized(bestPrediction.name);
            } else {
                clear(false);
            }
        }
    }
}