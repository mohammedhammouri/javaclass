package com.example.usecase;

import com.example.Clas;
import com.example.mapper.ClasMapper;

import java.util.HashMap;
import java.util.List;

public class UpdateClas implements UseCase<HashMap<String,String>,Clas> {

    private ClasMapper clasMapper;
    private List<Clas> classes;

    public UpdateClas(ClasMapper clasMapper, List<Clas> classes) {
        this.clasMapper = clasMapper;
        this.classes = classes;
    }

    @Override
    public Clas execute(HashMap<String, String> keyValues) throws Exception {
        Clas clas = clasMapper.map(keyValues);
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getName().equals(clas.getName())) {
                classes.set(i, clas);
                break;
            }
        }

        return clas;
    }

}
