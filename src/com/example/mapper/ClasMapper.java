package com.example.mapper;

import com.example.Clas;
import com.example.WrongDataException;

import java.util.HashMap;

public class ClasMapper implements Mapper<HashMap<String,String>,Clas> {

    @Override
    public Clas map(HashMap<String, String> hashMap) {
        Clas clas = new Clas();
        clas.setName(hashMap.get("name"));
        clas.setTeacherName(hashMap.get("teacherName"));
        return clas;
    }

    @Override
    public HashMap<String, String> mapTo(Clas clas) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name",clas.getName());
        map.put("teacherName",clas.getTeacherName());
        return map;
    }
}
