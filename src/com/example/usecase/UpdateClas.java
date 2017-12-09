package com.example.usecase;

import com.example.Clas;
import com.example.mapper.ClasMapper;
import com.example.repo.ClasRepo;
import sun.nio.cs.ext.IBM037;

import java.util.HashMap;
import java.util.List;

public class UpdateClas implements UseCase<HashMap<String,Object>,Clas> {

    private ClasMapper clasMapper;
    private ClasRepo clasRepo;

    public UpdateClas(ClasMapper clasMapper, ClasRepo clasRepo) {
        this.clasMapper = clasMapper;
        this.clasRepo = clasRepo;
    }

    @Override
    public Clas execute(HashMap<String, Object> keyValues) throws Exception {
        Clas clas = clasMapper.map(keyValues);

        return clas;
    }

}
