package com.example;

import com.example.cor.DoSth;
import com.example.cor.DoSth2;
import com.example.cor.DoSth3;
import com.example.cor.Sth;
import com.example.mapper.ClasMapper;
import com.example.mapper.Mapper;
import com.example.mapper.StudentMapper;
import com.example.usecase.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static List<Clas> classes = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    private static ClasMapper clasMapper = new ClasMapper();
    private static StudentMapper studentMapper = new StudentMapper();

    private static GetClass getClass =
            new GetClass(classes);
    private static CreateStudent createStudent;
//            new CreateStudent(classes, studentMapper, scanner, getClass);
    private static CreateClas createClas;
//            = new CreateClas(classes);
    private static GetStudent getStudent;
//            = new GetStudent(classes);

    public static void main(String[] args) throws IOException {
//        Sth doSth = new DoSth();
//        Sth doSth2 = new DoSth2();
//        Sth doSth3 = new DoSth3();
//
//        doSth.setNextInChain(doSth2);
//        doSth2.setNextInChain(doSth3);
//
//        doSth.execute();

        GetClass getClass = new GetClass(classes);
        try {
            getClass.execute("fdfd");
            getClass.execute("sss");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Get get = new Get();
        try {
            get.execute("ddd", classes);
            get.execute("dddssss", classes);
            get.execute("dddssss", classes);
            get.execute("dddssss", classes);
            get.execute("dddssss", classes);
            get.execute("dddssss", classes);
        } catch (NoClasFound noClasFound) {
            noClasFound.printStackTrace();
        }


        try {
            Student student = getStudent.execute("ddd");
            if(student != null)
                System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        askForInput();

        classes.get(classes.size());

        for (int i = 0; i < classes.size(); i++) {
            Clas c = classes.get(i);
            System.out.println(c);
        }
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
