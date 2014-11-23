package com.example.amos.sneakyfingers;

import java.util.Date;

import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.util.Log;


public class SneakyGestureReceiver extends View  {
    public MotionProcessor motionProcessor;
    public SneakyGestureReceiverListener listener;
    public SneakyGestureReceiver(Context context, AttributeSet attrs) {
        super(context, attrs);
        motionProcessor = new MotionProcessorSimpleAverage();
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        boolean consumed = super.onTouchEvent(event);

        long max_tap_duration = 270;
        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            long press_duration = event.getEventTime() - event.getDownTime();
            if (press_duration <= max_tap_duration)
                listener.tapped(this, event.getEventTime());
            Log.i("SneakyFingers", "event duration: " + press_duration + "ms");
        }

        motionProcessor.processMotionEvent(event);

        if (motionProcessor.hasNewSwipeDirection()) {
            listener.swipeChanged(this, motionProcessor.getCurrentSwipeDirection());
        }

        if (motionProcessor.shouldTrigger())
            listener.trigger();



        return true;
    }

}