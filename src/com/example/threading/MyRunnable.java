package com.example.threading;

public class MyRunnable implements Runnable {

    private ThreadMain.Callback callback;

    public MyRunnable(ThreadMain.Callback callback) {
        this.callback = callback;
    }

    public void setCallback(ThreadMain.Callback callback) {
        this.callback = callback;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName());
        callback.done("Something");
    }
}
