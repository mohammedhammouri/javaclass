package com.example;

public class MissingDataException extends Exception{

    private final int numOfMissingFields;

    public MissingDataException(int numOfMissingFields) {
        this.numOfMissingFields = numOfMissingFields;
    }
//////
    public int getNumOfMissingFields() {
        return numOfMissingFields;
    }
}
