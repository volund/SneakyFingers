package com.example.amos.sneakyfingers;

import android.view.MotionEvent;

/**
 *
 */
public interface MotionProcessor {
    public void processMotionEvent(MotionEvent event);
    public boolean hasNewSwipeDirection();
    public void reset();
    public boolean shouldTrigger();
    public Direction getCurrentSwipeDirection();
}
