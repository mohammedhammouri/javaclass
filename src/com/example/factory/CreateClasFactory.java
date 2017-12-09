package com.example.factory;

import com.example.Clas;
import com.example.mapper.ClasMapper;
import com.example.repo.ClasRepo;
import com.example.usecase.CreateClas;
import jdk.internal.dynalink.support.ClassMap;

import java.util.ArrayList;
import java.util.List;

public class CreateClasFactory extends BaseFactory<CreateClas> {

    private static CreateClas createClas;

    public CreateClas get(){
        if(createClas == null)
            createClas = new CreateClas(
                    FactoryOfFactories.getFactory(ClasMapper.class).get()
                    ,FactoryOfFactories.getFactory(ClasRepo.class).get());

        return createClas;
    }


}
