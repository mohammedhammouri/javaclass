package com.example.factory;

import com.example.Student;
import com.example.mapper.ClasMapper;
import com.example.mapper.StudentMapper;
import com.example.repo.StudentsRepo;
import com.example.usecase.CreateClas;
import com.example.usecase.CreateStudent;
import com.example.usecase.GetClass;
import com.example.usecase.UpdateClas;
import jdk.internal.dynalink.support.ClassMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateStudentFactory extends BaseFactory<CreateStudent> {

    private static CreateStudent createStudent;

    @Override
    public CreateStudent get() {

        if(createStudent  == null)
            createStudent = new CreateStudent(
                    FactoryOfFactories.getFactory(StudentsRepo.class).get(),
                    FactoryOfFactories.getFactory(StudentMapper.class).get(),
                    FactoryOfFactories.getFactory(Scanner.class).get(),
                    FactoryOfFactories.getFactory(GetClass.class).get(),
                    FactoryOfFactories.getFactory(CreateClas.class).get(),
                    FactoryOfFactories.getFactory(ClasMapper.class).get(),
                    FactoryOfFactories.getFactory(UpdateClas.class).get()
            );


        return createStudent;
    }


}
