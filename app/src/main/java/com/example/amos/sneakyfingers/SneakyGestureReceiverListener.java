package com.example.amos.sneakyfingers;

/**
 * Created by amos on 01/11/14.
 */
public interface SneakyGestureReceiverListener {
    public void swipeChanged(SneakyGestureReceiver view, Direction dir);
    public void trigger();
}
