package com.example.threading;

public class MyRunnable implements Runnable {

    private ThreadMain.Callback callback;

    public MyRunnable(ThreadMain.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        System.out.println("From runnable : "+ Thread.currentThread().getName());

        callback.done("something");

    }
}
