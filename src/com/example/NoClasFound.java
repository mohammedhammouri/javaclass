package com.example;

public class NoClasFound extends Exception {

    private final String missingClassName;

    public NoClasFound(String missingClassName) {
        super("No class found exception");
        this.missingClassName = missingClassName;
    }

    public String getMissingClassName() {
        return missingClassName;
    }
}
