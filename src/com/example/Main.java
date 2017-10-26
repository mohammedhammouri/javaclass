package com.example;

import com.example.cor.DoSth;
import com.example.cor.DoSth2;
import com.example.cor.DoSth3;
import com.example.cor.Sth;
import com.example.mapper.ClasMapper;
import com.example.mapper.Mapper;
import com.example.mapper.StudentMapper;
import com.example.usecase.CreateStudent;
import com.example.usecase.GetClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static List<Clas> classes = new ArrayList<>();
    private static ClasMapper clasMapper = new ClasMapper();
    private static StudentMapper studentMapper = new StudentMapper();

    private static GetClass getClass =
            new GetClass(classes);
    private static CreateStudent createStudent =
            new CreateStudent(classes,studentMapper,scanner,getClass);

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
            for(int i = 2 ; i < info.length;i++) {
                String[] keyValue = info[i].split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                keyValues.put(key,value);
            }

            String[] dataInput = input.split(",");

            //create,c,ssss
            //update,s...
            if(input.startsWith("create")) {

                if (dataInput[1].equals("c")) {
                    Clas clas = clasMapper.map(keyValues);
                    classes.add(clas);
                } else if (dataInput[1].equals("s")) {
                    try {
                        createStudent.execute(keyValues);
                    } catch (WrongDataException e) {

                    }
                }
            }else if(input.startsWith("update")){

                if (dataInput[1].equals("c")) {
                    Clas clas = clasMapper.map(keyValues);
                    for(int i = 0 ; i < classes.size();i++){
                        if(classes.get(i).getName().equals(clas.getName())){
                            classes.set(i,clas);
                            break;
                        }
                    }

                }else if(dataInput[1].equals("s")){
                    Student student = studentMapper.map(keyValues);
                    try {
                        Clas c = getClass(student.getClassName());

                        List<Student> students = c.getStudents();
                        for(int i =0;i < students.size();i++){

                            if(students.get(i).getName().equals(student.getName())){
                                students.set(i,student);

                                c.setStudents(students);
                                for(int j = 0 ; j < classes.size();j++){
                                    if(classes.get(j).getName().equals(c.getName())){
                                        classes.set(j,c);
                                    }
                                }
                                break;
                            }

                        }

                    } catch (NoClasFound noClasFound) {
                    }
                }

            }else if(input.startsWith("delete")){



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
