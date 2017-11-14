package com.example.threading;

import java.util.concurrent.Callable;

public class MyRunnable implements Callable<String> {

    private ThreadMain.Callback callback;

    public MyRunnable(ThreadMain.Callback callback) {
        this.callback = callback;
    }

//    @Override
//    public void run() {
//
//
//    }

    @Override
    public String call() throws Exception {
        System.out.println("From runnable : "+ Thread.currentThread().getName());

        return "something";
    }
}
