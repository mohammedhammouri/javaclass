package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

public class wrongDataexception extends Exception {
    String dataNameExceptio;
    String Massage;

    public wrongDataexception(String MASSAGE,String dataNameExceptio) {
        super(MASSAGE);
        this.dataNameExceptio = dataNameExceptio;
    }

    public String getDataNameExceptio() {
        return dataNameExceptio;
    }
}
