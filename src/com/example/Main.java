package com.example;

import com.example.cor.DoSth;
import com.example.cor.DoSth2;
import com.example.cor.DoSth3;
import com.example.cor.Sth;
import com.example.factory.CreateClasFactory;
import com.example.factory.Factory;
import com.example.factory.FactoryOfFactories;
import com.example.factory.StudentsRepoFactory;
import com.example.mapper.ClasMapper;
import com.example.mapper.Mapper;
import com.example.mapper.StudentMapper;
import com.example.repo.StudentsRepo;
import com.example.usecase.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static CreateClas createClas;
    private static CreateStudent createStudent;
    private static GetClass getClass;
    private static GetStudent getStudent;
    private static UpdateClas updateClas;
    private static UpdateStudent updateStudent;
    private static Scanner scanner;


    public static void main(String[] args) throws IOException {
        createClas = FactoryOfFactories.getFactory(CreateClas.class).get();
        createStudent = FactoryOfFactories.getFactory(CreateStudent.class).get();
        getClass = FactoryOfFactories.getFactory(GetClass.class).get();
        getStudent = FactoryOfFactories.getFactory(GetStudent.class).get();
        updateClas = FactoryOfFactories.getFactory(UpdateClas.class).get();
        updateStudent = FactoryOfFactories.getFactory(UpdateStudent.class).get();
        scanner = FactoryOfFactories.getFactory(Scanner.class).get();

        try {
            askForInput();
        } catch (Exception e) {
            System.out.println("Some error happened : " + e.getMessage());
        }
    }

    private static void askForInput() throws Exception {

        String input = scanner.next();

        while (!input.equals("done")) {

            HashMap<String, Object> keyValues = new HashMap<>();

            //c,s,name:fdfs,fdfd:fdf
            String[] info = input.split(",");
            for (int i = 2; i < info.length; i++) {
                String[] keyValue = info[i].split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                keyValues.put(key, value);
            }

            switch (info[0]){
                case "c"://create
                    if(info[1].equals("c"))
                        createClas.execute(keyValues);
                    else if(info[1].equals("s"))
                        createStudent.execute(keyValues);
                break;
                case "u"://create
                    if(info[1].equals("c"))
                        updateClas.execute(keyValues);
                    else if(info[1].equals("s"))
                        updateStudent.execute(keyValues);
                    break;

            }



            input = scanner.next();

        }

    }


}
