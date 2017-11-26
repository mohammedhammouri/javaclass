package com.company;

import com.sun.tools.corba.se.idl.ExceptionEntry;

public class NoChasFound extends Exception{
    String missingclasname;

    public NoChasFound(String missingclasname) {
        this.missingclasname = missingclasname;
    }

    public String getMissingclasname(){
        return missingclasname;

    }
}
