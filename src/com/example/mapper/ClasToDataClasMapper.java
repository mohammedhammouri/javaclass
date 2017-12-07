package com.example.mapper;

import com.example.Clas;
import com.example.Student;
import com.example.repo.DataClas;
import com.example.repo.StudentsRepo;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class ClasToDataClasMapper implements Mapper<Clas,DataClas> {

    private StudentsRepo studentsRepo;

    public ClasToDataClasMapper(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    @Override
    public DataClas map(Clas clas) {
        DataClas dataClas = new DataClas();
        dataClas.setName(clas.getName());
        dataClas.setTeacherName(clas.getTeacherName());
        List<String> stIds = new ArrayList<>();

        for (Student student : clas.getStudents()) {
            stIds.add(student.getName());
        }

        dataClas.setStudentsNames(stIds);

        return dataClas;
    }

    @Override
    public Clas mapTo(DataClas dataClas) {
        Clas clas = new Clas();
        clas.setName(dataClas.getName());
        clas.setTeacherName(dataClas.getTeacherName());
        List<Student> students = new ArrayList<>();

        for (String s : dataClas.getStudentsNames()) {
           students.add(studentsRepo.get(s));
        }

        clas.setStudents(students);

        return clas;
    }
}
