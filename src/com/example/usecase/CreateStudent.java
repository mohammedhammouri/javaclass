package com.example.usecase;

import com.example.Clas;
import com.example.NoClasFound;
import com.example.Student;
import com.example.WrongDataException;
import com.example.mapper.ClasMapper;
import com.example.mapper.StudentMapper;
import com.example.repo.StudentsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CreateStudent implements UseCase<HashMap<String,Object>,Student>{

    private StudentMapper studentMapper;
    private StudentsRepo studentsRepo;

    @Override
    public Student execute(HashMap<String, Object> hashMap) throws Exception {
        Student s = studentMapper.map(hashMap);

        if(s.getClassName() == null)
            throw new NullPointerException("dsds");

        studentsRepo.create(s);

        return s;
    }

}
