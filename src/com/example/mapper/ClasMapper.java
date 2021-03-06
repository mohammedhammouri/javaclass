package com.example.mapper;

import com.example.Clas;
import com.example.Student;
import com.example.WrongDataException;

import java.util.HashMap;
import java.util.List;

public class ClasMapper implements Mapper<HashMap<String,Object>,Clas> {

    @Override
    public Clas map(HashMap<String, Object> hashMap) {
        Clas clas = new Clas();
        clas.setName((String) hashMap.get("name"));
        clas.setTeacherName((String) hashMap.get("teacherName"));
        clas.setStudents((List<Student>) hashMap.get("students"));
        return clas;
    }

    @Override
    public HashMap<String, Object> mapTo(Clas clas) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",clas.getName());
        map.put("teacherName",clas.getTeacherName());
        map.put("students",clas.getStudents());
        return map;
    }




}
