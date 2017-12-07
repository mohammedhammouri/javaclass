package com.example.repo;

import com.example.Student;

import java.util.List;

public class DataClas {

    private String name;
    private String teacherName;
    private List<String> studentsNames;
    //classs 0 s1,s2,s3,s4,s5
    //classs 1 s1,s2,s3,s4,s5

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<String> getStudentsNames() {
        return studentsNames;
    }

    public void setStudentsNames(List<String> studentsNames) {
        this.studentsNames = studentsNames;
    }
}
