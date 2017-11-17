package com.example.threading;

import java.util.concurrent.*;

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

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Thread t = new Thread(myRunnable);
//        myRunnable.run();
//
//        t.start();

        ExecutorService executor = Executors.newFixedThreadPool(100);
//
//        Callable<String> c = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(2000);
//                return "SomeCode";
//            }
//        };
//
//        Future<String> result = executor.submit(c);

//        Thread.sleep(2000);
//        System.out.println("SomeCode");

//        System.out.println("Something");
//        System.out.println("Something2");
//        System.out.println("Something3");
//
//        System.out.println(result.get());
//
//        System.out.println("Done");

        Counter counter = new Counter();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                counter.increaseCount();
            }
        };

        for(int i = 0;i < 100;i++){
            executor.submit(runnable);
        }


    }


}
