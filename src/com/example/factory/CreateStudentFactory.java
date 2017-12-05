package com.example.factory;

import com.example.Student;
import com.example.mapper.ClasMapper;
import com.example.mapper.StudentMapper;
import com.example.usecase.CreateClas;
import com.example.usecase.CreateStudent;
import com.example.usecase.GetClass;
import com.example.usecase.UpdateClas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateStudentFactory implements Factory<CreateStudent> {

    private static List<Student> studentList;
    private static CreateStudent createStudent;

    @Override
    public CreateStudent get() {
        if(studentList == null)
            studentList = new ArrayList<>();

        if(createStudent  == null)
            createStudent = new CreateStudent(
                    studentList,
                    FactoryOfFactories.getFactory(.class).get(),
                    FactoryOfFactories.getFactory(Scanner.class).get(),
                    FactoryOfFactories.getFactory(GetClass.class).get(),
                    FactoryOfFactories.getFactory(CreateClas.class).get(),
                    FactoryOfFactories.getFactory(ClasMapper.class).get(),
                    FactoryOfFactories.getFactory(UpdateClas.class).get()
            );


        return createStudent;
    }


}
