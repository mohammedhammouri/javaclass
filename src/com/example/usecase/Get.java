package com.example.usecase;

import com.example.Clas;
import com.example.NoClasFound;

import java.util.List;

/**
 * Wrong implemntation of {@link GetClass}
 */
public class Get {

    public Clas execute(String className, List<Clas> classes) throws NoClasFound {
        for(int i = 0 ; i < classes.size();i++){

            Clas c = classes.get(i);
            if(c.getName().equals(className))
                return c;

        }

        throw new NoClasFound(className);
    }

}
