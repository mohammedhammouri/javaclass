package com.example.factory;

public abstract class BaseFactory<R> implements Factory<R> {

    private boolean test;

    @Override
    public void setTest(boolean test) {
        this.test =test;
    }

    protected boolean isTest() {
        return test;
    }

}
