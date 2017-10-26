package com.example.usecase;

import com.example.Clas;
import com.example.NoClasFound;
import com.example.Student;
import com.example.WrongDataException;
import com.example.mapper.StudentMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CreateStudent implements UseCase<HashMap<String,String>,Student>{

    private final List<Clas> classes;
    private final StudentMapper studentMapper;
    private final Scanner scanner;
    private final GetClass getClass;

    public CreateStudent(List<Clas> classes, StudentMapper studentMapper, Scanner scanner, GetClass getClass) {
        this.classes = classes;
        this.studentMapper = studentMapper;
        this.scanner = scanner;
        this.getClass = getClass;
    }

    @Override
    public Student execute(HashMap<String, String> hashMap) throws WrongDataException {
        Student s = studentMapper.map(hashMap);
        if(s.getName() == null)
            throw new WrongDataException("null name","name");
        if(s.getName().length() > 20)
            throw new WrongDataException("Name length must be less than 20","name");

        Clas c = null;
        try {
            c = getClass.execute(s.getClassName());
            c.addStudent(s);
        } catch (NoClasFound noClasFound) {
            System.out.println("Enter teacher name for class : " + noClasFound.getMissingClassName());
            String teacherName = scanner.next();
            Clas clas = new Clas();
            clas.setName(noClasFound.getMissingClassName());
            clas.setTeacherName(teacherName);
            clas.addStudent(s);
            classes.add(clas);
        } catch (Exception e) {
        }
        return s;
    }

}
