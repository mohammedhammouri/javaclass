package com.company;

public class MissDataException extends Exception {

    final  int numOfMIssingFeiled ;

    public MissDataException(int numOfMIssingFeiled) {
        this.numOfMIssingFeiled = numOfMIssingFeiled;
    }

public int GetMissngFeiled (){return numOfMIssingFeiled;
    }
}
