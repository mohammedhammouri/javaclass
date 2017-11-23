package com.example.threading;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.Optional;
import java.util.concurrent.*;

public class ThreadMain {


    static interface Callback{

        void done(String s);

    }

    static interface Callback2{
        void done2(int s);
    }

//
//
//    static Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getName());
//        }
//    };
//
    static Callback c = new Callback() {
        @Override
        public void done(String s) {
            System.out.println("From callback : " + Thread.currentThread().getName());
            System.out.println("Recivied event : " + s);
        }
    };

//    static MyCallable myRunnable = new MyCallable(c);

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    };


//    static Counter c;
    public static void main(String[] args) throws InterruptedException, ExecutionException {


//        MyRunnable myRunnable = new MyRunnable(c);
//        myRunnable.run();
//
//        runnable.run();

//        Thread thread = new Thread(myRunnable);
//        thread.start();
//
//        Thread t = new Thread("System.out.println(Thraed.current....)");


//        Thread t = new Thread(myRunnable);
//        myRunnable.run();

//        t.start();

//        ExecutorService executor = Executors.newFixedThreadPool(100);
//
//        Future<String> future = executor.submit(new MyCallable());
//
        ////4
        ////
        ////
        ////
        ////
        ////

//
//        String s = future.get();

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


//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                counter.increaseCount();
//            }
//        };
//
//        for(int i = 0;i < 100;i++){
//            executor.submit(runnable);
//        }


//        Counter counter = new Counter(1,"ds");
//
//        Counter c2 = counter.withCount(2);
//
//        Counter c4 = new Counter.Builder()
//                .fromPrototype(c2)
//                .s("fd")
//                .count(3)
//                .build();
//
//        Optional<String> s1 = c4.getS();
//
//        if(s1.isPresent()){
//            System.out.println(s1.get());
//        }
//
//        Counter c2 = new Counter(counter.getCount()+1,counter.getS().get());


//        String s = someMethod();
//
//        System.out.println(s);
//
//        String s2 = someMethod2(s);
//
        someMethod(s -> {
            System.out.println(s);
            int c = Integer.parseInt(s);
            someMethod2(c, s1 -> {
                System.out.println(s1);
            });
        });



        Observable<String> fdfdf = method("fdfdf");

        fdfdf.flatMap(new Function<String, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(String s) throws Exception {
                return Observable.just(Integer.parseInt(s));
            }
        }).flatMap(new Function<Integer, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Integer value) throws Exception {
                        return value == 1 ? Observable.just(true) : Observable.just(false);
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                    }
                });
    }

    public static String someMethod(){
        return "something";
    }

    public static String someMethod2(String s){
        return s;
    }


    public static Observable<String> method(String s){
        return Observable.just("something","Something2","Something3");

//        return Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("Something");
//                emitter.onNext("Something2");
//                emitter.onNext("Something3");
//            }
//        });
    }

    public static void someMethod(Callback c){
        c.done("something");
        c.done("dfdfd");
    }

    public static void someMethod2(int s,Callback2 c){
        c.done2(s);
    }

}
