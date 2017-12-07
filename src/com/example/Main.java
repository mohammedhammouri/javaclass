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



    public static void main(String[] args) throws IOException {
        askForInput();
    }

    private static void askForInput() {

        String input = scanner.next();

        while (!input.equals("done")) {

            HashMap<String, String> keyValues = new HashMap<>();

            //c,s,name:fdfs,fdfd:fdf
            String[] info = input.split(",");
            for (int i = 2; i < info.length; i++) {
                String[] keyValue = info[i].split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                keyValues.put(key, value);
            }

            try {
                Main.createClas.execute(keyValues);
            }
            catch (Exception e) {

            }

            input = scanner.next();

        }

    }


    private static Clas getClass(String className) throws NoClasFound {
        for (int i = 0; i < classes.size(); i++) {

            Clas c = classes.get(i);
            if (c.getName().equals(className))
                return c;

        }

        throw new NoClasFound(className);
    }


}
