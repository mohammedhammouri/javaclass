package com.example.repo;

import com.example.Student;
import com.example.mapper.StudentMapper;

import java.util.List;

public interface StudentsRepo {

    Student create(Student student);

    Student update(String id,Student student);

    Student remove(Student student);

    Student get(String id);

    List<Student> getAll();

    List<Student> query(String clsasName,int seatNumber);

}
