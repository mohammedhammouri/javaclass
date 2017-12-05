package com.example.repo_impl;

import com.example.Student;
import com.example.repo.StudentsRepo;

import java.util.ArrayList;
import java.util.List;

public class NetworkStudentRepo implements StudentsRepo {

    private List<Student> students = new ArrayList<>();

    @Override
    public Student create(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student update(String id, Student student) {

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(id)) {
                students.set(i, student);
                return student;
            }
        }

        return student;
    }

    @Override
    public Student remove(Student student) {
        students.remove(student);
        return student;
    }

    @Override
    public Student get(String id) {

        for (Student student : students) {
            if(student.getName().equals(id))
                return student;
        }

        return null;
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public List<Student> query(String clsasName, int seatNumber) {
        List<Student> finalResult = new ArrayList<>();
        for (Student student : students) {
            if(student.getClassName().equals(clsasName)
                    || student.getSeatNumber() == seatNumber)
                finalResult.add(student);
        }

        return finalResult;
    }
}
