package com.example.usecase;

import com.example.Clas;
import com.example.mapper.ClasMapper;
import com.example.repo.ClasRepo;

import java.util.HashMap;
import java.util.List;

public class CreateClas implements UseCase<HashMap<String,Object>,Clas>{

    private ClasMapper clasMapper;
    private ClasRepo clasRepo;

    public CreateClas(ClasMapper clasMapper, ClasRepo clasRepo) {
        this.clasMapper = clasMapper;
        this.clasRepo = clasRepo;
    }

    @Override
    public Clas execute(HashMap<String, Object> hashMap) throws Exception {

        Clas c = clasMapper.map(hashMap);

        return clasRepo.create(c);
    }


}
