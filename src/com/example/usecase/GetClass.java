package com.example.usecase;

import com.example.Clas;
import com.example.MissingDataException;
import com.example.NoClasFound;
import com.example.repo.ClasRepo;

import java.util.List;

public class GetClass implements UseCase<String,Clas> {

    private ClasRepo clasRepo;

    public GetClass(ClasRepo clasRepo) {
        this.clasRepo = clasRepo;
    }

    @Override
    public Clas execute(String className) throws Exception {

        Clas c = clasRepo.get(className);

        if(c != null)
            return c;

        throw new NoClasFound(className);
    }

}
