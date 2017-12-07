package com.example.usecase;

import com.example.Clas;
import com.example.Student;
import com.example.mapper.StudentMapper;

import java.util.HashMap;
import java.util.List;

public class CreateStudent2 extends UseCase<HashMap<String,String>,Student>{

    private GetClass getClass;
    private UpdateClas updateClas;
    private List<Student> stundetList;
    private StudentMapper studentMapper;

    @Override
    public Student execute(HashMap<String, String> hashMap) throws Exception {
        Student s = studentMapper.map(hashMap);
        
        Clas clas = getClass.execute(s.getClassName());

        List<Student> students = clas.getStudents();
        students.add(s);

        clas.setStudents(students);

        updateClas.execute(clas);

        stundetList.add(s);


        return null;
    }
}
