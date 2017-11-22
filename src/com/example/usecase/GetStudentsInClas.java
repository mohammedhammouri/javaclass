package com.example.usecase;

import com.example.Clas;
import com.example.Student;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsInClas implements UseCase<String,List<Student>> {

    private GetClass getClass;
    private GetStudent getStudent;

    public GetStudentsInClas(GetClass getClass, GetStudent getStudent) {
        this.getClass = getClass;
        this.getStudent = getStudent;
    }

    @Override
    public List<Student> execute(String s) throws Exception {
        Clas c = getClass.execute(s);

        List<Student> students = new ArrayList<>(c.getStudentsNames().size());

        for (int i = 0; i < c.getStudentsNames().size(); i++) {
            String sName = c.getStudentsNames().get(i);

            Student student = getStudent.execute(sName);

            students.add(student);
        }


        return students;
    }
}
