package com.example;

import com.example.cor.DoSth;
import com.example.cor.DoSth2;
import com.example.cor.DoSth3;
import com.example.cor.Sth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static List<Clas> classes = new ArrayList<>();

    public static void main(String[] args)  {

//        Sth doSth = new DoSth();
//        Sth doSth2 = new DoSth2();
//        Sth doSth3 = new DoSth3();
//
//        doSth.setNextInChain(doSth2);
//        doSth2.setNextInChain(doSth3);

//        doSth.execute();


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

            IOParser parser = null;
            if(input.startsWith("c")){
                parser = new Clas();
            }else if(input.startsWith("s")) {
                parser = new Student();
            }

            try {
                parser.parse(input);
            } catch (WrongDataException e) {
                System.out.println(e.getMessage());
                askForInput();
            } catch (MissingDataException e) {
                System.out.println(e.getMessage());
                askForInput();
            }

            if(parser instanceof Clas){
                classes.add((Clas) parser);
            }else if(parser instanceof Student){
                Student s = (Student) parser;
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
