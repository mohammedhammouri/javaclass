package com.example.threading;

public class CounterBuilder {
    private int count = 5;
    private String s;

    public CounterBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public CounterBuilder setS(String s) {
        this.s = s;
        return this;
    }

    public Counter build(){
        return new Counter(count,s);
    }

}