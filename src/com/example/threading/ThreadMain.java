package com.example.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMain {



    static interface Callback{

        void done(String s);

    }


    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    };

    static Callback c = new Callback() {
        @Override
        public void done(String s) {
            System.out.println("From callback : " + Thread.currentThread().getName());
            System.out.println("Recivied event : " + s);
        }
    };

    static MyRunnable myRunnable = new MyRunnable(c);


    public static void main(String[] args) {
//        Thread t = new Thread(myRunnable);
//        myRunnable.run();
//
//        t.start();


        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<String> future = executor.submit(myRunnable);

        ///
        //
        //
        ///

        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }



    }


}
