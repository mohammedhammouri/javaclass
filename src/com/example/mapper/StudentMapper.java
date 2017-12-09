package com.example.mapper;

import com.example.Student;

import java.util.HashMap;

public class StudentMapper implements Mapper<HashMap<String,Object>,Student> {
    
    @Override
    public Student map(HashMap<String, Object> hashMap) {
        Student student = new Student();
        student.setName((String) hashMap.get("name"));
        student.setClassName((String) hashMap.get("class"));
        student.setSeatNumber(Integer.parseInt((String) hashMap.get("seatNumber")));
        return student;
    }

    @Override
    public HashMap<String, Object> mapTo(Student student) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",student.getName());
        map.put("class",student.getClassName());
        map.put("seatNumber", String.valueOf(student.getSeatNumber()));
        return map;
    }
}
