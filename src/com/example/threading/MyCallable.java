package com.example.threading;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

//    private ThreadMain.Callback callback;
//
//    public MyCallable(ThreadMain.Callback callback) {
//        this.callback = callback;
//    }

//    @Override
//    public void run() {
//
//
//    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName());
        return "Test";
    }
}
