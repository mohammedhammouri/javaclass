package com.example.repo_impl;

import com.example.Clas;
import com.example.mapper.ClasMapper;
import com.example.mapper.ClasToDataClasMapper;
import com.example.repo.ClasRepo;
import com.example.repo.DataClas;

import java.util.ArrayList;
import java.util.List;

public class InMemoryClasRepo implements ClasRepo{

    private List<DataClas> dataClasList = new ArrayList<>();

    private ClasToDataClasMapper mapper;

    @Override
    public Clas create(Clas Clas) {

        DataClas dataClas = mapper.map(Clas);

        dataClasList.add(dataClas);

        return Clas;
    }

    @Override
    public Clas update(String id, Clas Clas) {
        return null;
    }

    @Override
    public Clas remove(Clas Clas) {
        return null;
    }

    @Override
    public Clas get(String id) {

        for (DataClas dataClas : dataClasList) {
            if(dataClas.getName().equals(id))
                return mapper.mapTo(dataClas);
        }

        return null;
    }

    @Override
    public List<Clas> getAll() {
        return null;
    }

    @Override
    public List<Clas> query(String clasName, String teacherName) {
        return null;
    }
}
