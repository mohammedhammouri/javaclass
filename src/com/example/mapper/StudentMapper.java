package com.example.mapper;

import com.example.Student;

import java.util.HashMap;

public class StudentMapper implements Mapper<HashMap<String,String>,Student> {
    
    @Override
    public Student map(HashMap<String, String> hashMap) {
        Student student = new Student();
        student.setName(hashMap.get("name"));
        student.setClassName(hashMap.get("class"));
        student.setSeatNumber(Integer.parseInt(hashMap.get("seatNumber")));
        return student;
    }

    @Override
    public HashMap<String, String> mapTo(Student student) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name",student.getName());
        map.put("class",student.getClassName());
        map.put("seatNumber", String.valueOf(student.getSeatNumber()));
        return map;
    }
}
