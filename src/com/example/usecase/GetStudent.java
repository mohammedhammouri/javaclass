package com.example.usecase;

import com.example.Clas;
import com.example.Student;
import com.example.repo.StudentsRepo;

import java.util.List;

/**
 *
 */
public class GetStudent implements UseCase<String,Student> {

    private final StudentsRepo studentsRepo;

    public GetStudent(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    /**
     * Some explanation
     * @param s student name
     * @return a student with the given name
     * @throws Exception if student not found
     */
    @Override
    public Student execute(String s) throws Exception {
        if(s == null || s.isEmpty())
            throw new Exception("Null data");

        return studentsRepo.get(s);

    }



}
