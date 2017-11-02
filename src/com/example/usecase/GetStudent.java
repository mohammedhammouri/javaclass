package com.example.usecase;

import com.example.Clas;
import com.example.Student;

import java.util.List;

public class GetStudent implements UseCase<String,Student> {

    private final List<Clas> classes;

    public GetStudent(List<Clas> classes) {
        this.classes = classes;
    }

    @Override
    public Student execute(String s) throws Exception {
        if(s == null || s.isEmpty())
            throw new Exception("Null data");


        for (int i = 0; i < classes.size(); i++) {
            Clas c = classes.get(i);

            for (int j = 0; j < c.getStudents().size(); j++) {
               Student student = c.getStudents().get(j);
               if(student.getName().equals(s))
                   return student;
            }

        }


        throw new Exception("No student found");
    }



}
