package com.example.threading;

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


    static MyRunnable myRunnable = new MyRunnable(new Callback() {
        @Override
        public void done(String s) {

            System.out.println("From callback : " + Thread.currentThread().getName());
            System.out.println("Recivied event : " + s);
        }
    });


    public static void main(String[] args) {


//        System.out.println(Thread.currentThread().getName());
//        runnable.run();
//
//        Thread thread = new Thread(runnable,"SomeThread");
//        thread.start();
//
//        myRunnable.run();

        Thread t = new Thread(myRunnable,"ss");
        t.start();

//        Thread g = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//
//        g.start();



    }


}
