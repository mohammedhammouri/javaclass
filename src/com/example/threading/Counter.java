package com.example.threading;

public class Counter {

    int count = 0;
    Object o;

    public void increaseCount(){
        synchronized (o) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    //0.0001
    //1000000/s

}

