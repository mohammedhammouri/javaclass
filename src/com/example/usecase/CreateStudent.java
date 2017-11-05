package com.example.usecase;

import com.example.Clas;
import com.example.NoClasFound;
import com.example.Student;
import com.example.WrongDataException;
import com.example.mapper.ClasMapper;
import com.example.mapper.StudentMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CreateStudent implements UseCase<HashMap<String,String>,Student>{

    private final List<Student> students;
    private final StudentMapper studentMapper;
    private final Scanner scanner;
    private final GetClass getClass;
    private final CreateClas createClas;
    private final ClasMapper clasMapper;
    private final UpdateClas updateClas;

    public CreateStudent(List<Student> students, StudentMapper studentMapper, Scanner scanner, GetClass getClass, CreateClas createClas, ClasMapper clasMapper, UpdateClas updateClas) {
        this.students = students;
        this.studentMapper = studentMapper;
        this.scanner = scanner;
        this.getClass = getClass;
        this.createClas = createClas;
        this.clasMapper = clasMapper;
        this.updateClas = updateClas;
    }

    @Override
    public Student execute(HashMap<String, String> hashMap) throws Exception {
        Student s = studentMapper.map(hashMap);
        if(s.getName() == null)
            throw new WrongDataException("null name","name");
        if(s.getName().length() > 20)
            throw new WrongDataException("Name length must be less than 20","name");

        students.add(s);

        Clas c = null;
        try {
            c = getClass.execute(s.getClassName());
            c.addStudentName(s.getName());
            updateClas.execute(clasMapper.mapTo(c));
        } catch (NoClasFound noClasFound) {
            System.out.println("Enter teacher name for class : " + noClasFound.getMissingClassName());
            String teacherName = scanner.next();

            Clas clas = new Clas();
            clas.setName(noClasFound.getMissingClassName());
            clas.setTeacherName(teacherName);

            HashMap<String,String> clasData = clasMapper.mapTo(clas);

            Clas clas1 = createClas.execute(clasData);

            clas1.addStudentName(s.getName());

//            HashMap<String,String> ss = clasMapper.mapTo(clas1);

            updateClas.execute(clasMapper.mapTo(clas1));
//            updateClas.execute(ss);

        } catch (Exception e) {
        }


        return s;
    }

}
