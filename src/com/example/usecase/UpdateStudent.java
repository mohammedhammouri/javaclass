package com.example.usecase;

import com.example.Student;
import com.example.mapper.StudentMapper;
import com.example.repo.StudentsRepo;

import java.util.HashMap;
import java.util.List;

public class UpdateStudent implements UseCase<HashMap<String,Object>,Student> {

    private StudentMapper studentMapper;
    private StudentsRepo studentsRepo;

    public UpdateStudent(StudentMapper studentMapper, StudentsRepo studentsRepo) {
        this.studentMapper = studentMapper;
        this.studentsRepo = studentsRepo;
    }

    @Override
    public Student execute(HashMap<String, Object> keyValues) throws Exception {
        Student s = studentMapper.map(keyValues);

        return studentsRepo.update(s.getName(),s);
    }


}
