package com.example.usecase;

import com.example.Clas;

import java.util.HashMap;
import java.util.List;

public class CreateClas implements UseCase<HashMap<String,String>,Clas>{

    private final List<Clas> classes;


    public CreateClas(List<Clas> classes) {
        this.classes = classes;
    }

    @Override
    public Clas execute(HashMap<String, String> hashMap) throws Exception {
        Clas clas = new Clas();
        clas.setName(hashMap.get("name"));
        clas.setTeacherName(hashMap.get("teacherName"));

        classes.add(clas);

        return clas;
    }
}
