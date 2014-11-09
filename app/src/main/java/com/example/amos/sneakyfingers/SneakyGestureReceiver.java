package com.example.amos.sneakyfingers;

import android.view.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.util.Log;

public class SneakyGestureReceiver extends View  {
    public MotionProcessorSimpleAverage motionProcessor;
    public SneakyGestureReceiverListener listener;

    public SneakyGestureReceiver(Context context, AttributeSet attrs) {
        super(context, attrs);
        motionProcessor = new MotionProcessorSimpleAverage();
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        boolean consumed = super.onTouchEvent(event);
        /*
        if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {
            Log.i("SFR", "got masked event: " + event + "consumed " + consumed);
            Log.i("SFR", "X: " + event.getX(0) + " Y: " + event.getY(0));
        }*/

        motionProcessor.processMotionEvent(event);

        if (motionProcessor.hasNewSwipeDirection()) {
            listener.swipeChanged(this, motionProcessor.currentSwipeDirection);
        }

        /*
        // trigger based on swipe direction change
        if (motionProcessor.hasNewSwipeDirection()) {
            if (listener != null)
                listener.trigger();
        }*/

        // trigger based on distance swiped
        //Log.i("SneakyFingers", "distance: " + motionProcessor.distance);
        double threshold = 60;
        if (motionProcessor.distance >= threshold)
            listener.trigger();



        return true;
    }

}