package com.example;

public class WrongDataException extends Exception{

    private final String wrongDataName;

    public WrongDataException(String message, String wrongDataName) {
        super(message);
        this.wrongDataName = wrongDataName;
    }

    public String getWrongDataName() {
        return wrongDataName;
    }

}
