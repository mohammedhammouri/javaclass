package com.example.factory;

import com.example.Clas;
import com.example.usecase.CreateClas;

import java.util.ArrayList;
import java.util.List;

public class CreateClasFactory implements Factory<CreateClas>{

    private static List<Clas> clasList;
    private static CreateClas createClas;

    public CreateClas get(){
        if(clasList == null)
            clasList = new ArrayList<>();
        if(createClas == null)
            createClas = new CreateClas(clasList);

        return createClas;
    }

    private boolean test;

    @Override
    public void setTest(boolean test) {
        this.test = test;
    }


}
