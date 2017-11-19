package com.example.threading;

import java.util.Optional;

public class Counter {

    private final int count;
    private final String s;

    public Counter(int count, String s) {
        this.count = count;
        this.s = s;
    }

    private Counter(Builder builder) {
        this.count = builder.count;
//        this.count = com.google.common.base.Preconditions.checkNotNull(builder.count);
        this.s = builder.s;
    }


    public int getCount() {
        return count;
    }

    public Optional<String> getS() {
        return Optional.ofNullable(s);
    }

    public Counter withCount(int count){
        return new Builder()
                .count(count)
                .s(getS().get())
                .build();
    }

    public Counter withCount2(int count){
        return new Counter(count,getS().get());
    }

    public static class Builder {
        private int count;
        private String s;

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public Builder s(String s) {
            this.s = s;
            return this;
        }

        public Builder fromPrototype(Counter prototype) {
            count = prototype.count;
            s = prototype.s;
            return this;
        }

        public Counter build() {
            return new Counter(this);
        }

    }
}

