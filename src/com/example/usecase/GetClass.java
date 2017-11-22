package com.example.usecase;

import com.example.Clas;
import com.example.MissingDataException;
import com.example.NoClasFound;

import java.util.List;

public class GetClass implements UseCase<String,Clas> {
    private List<Clas> classes;

//    private final List<Clas> classes;
//
    public GetClass(List<Clas> classes) {
        this.classes = classes;
    }

    @Override
    public Clas execute(String className) throws Exception {

        for(int i = 0 ; i < classes.size();i++){

            Clas c = classes.get(i);
            if(c.getName().equals(className))
                return c;

        }

        throw new NoClasFound(className);

    }

}
