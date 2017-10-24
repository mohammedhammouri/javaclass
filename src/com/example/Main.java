package com.example;

import com.example.cor.DoSth;
import com.example.cor.DoSth2;
import com.example.cor.DoSth3;
import com.example.cor.Sth;
import com.example.mapper.ClasMapper;
import com.example.mapper.Mapper;
import com.example.mapper.StudentMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static List<Clas> classes = new ArrayList<>();
    private static ClasMapper clasMapper = new ClasMapper();
    private static StudentMapper studentMapper = new StudentMapper();

    public static void main(String[] args)  {

        Sth doSth = new DoSth();
        Sth doSth2 = new DoSth2();
        Sth doSth3 = new DoSth3();

        doSth.setNextInChain(doSth2);
        doSth2.setNextInChain(doSth3);

        doSth.execute();


        askForInput();

        classes.get(classes.size());

        for (int i = 0; i < classes.size(); i++) {
            Clas c = classes.get(i);
            System.out.println(c);
        }
    }

    private static void askForInput(){

        String input = scanner.next();

        while(!input.equals("done")){
            HashMap<String,String> keyValues = new HashMap<>();
            String[] info = input.split(",");
            for(int i = 1 ; i < info.length;i++) {
                String[] keyValue = info[i].split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                keyValues.put(key,value);
            }

            if(input.startsWith("c")){
                Clas clas = clasMapper.map(keyValues);
                classes.add(clas);
            }else if(input.startsWith("s")) {
                Student s = studentMapper.map(keyValues);
                Clas c = null;
                try {
                    c = getClass(s.getClassName());
                    c.addStudent(s);
                } catch (NoClasFound noClasFound) {
                    System.out.println("Enter teacher name for class : "+ noClasFound.getMissingClassName());
                    String teacherName = scanner.next();
                    Clas clas = new Clas();
                    clas.setName(noClasFound.getMissingClassName());
                    clas.setTeacherName(teacherName);
                    clas.addStudent(s);
                    classes.add(clas);
                }
            }

            input = scanner.next();

        }

    }


    private static Clas getClass(String className) throws NoClasFound {
        for(int i = 0 ; i < classes.size();i++){

            Clas c = classes.get(i);
            if(c.getName().equals(className))
                return c;

        }

        throw new NoClasFound(className);
    }


}
