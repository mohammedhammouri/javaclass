package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static List<Clas> classes = new ArrayList<>();

    public static void main(String[] args)  {
//        askForInput();

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
            } catch (Exception e) {
                System.out.println(e.getMessage());
                askForInput();
            }

            if(parser instanceof Clas){
                classes.add((Clas) parser);
            }else if(parser instanceof Student){
                Student s = (Student) parser;
                Clas c = getClass(s.getClassName());
                if(c != null) c.addStudent(s);
            }

            input = scanner.next();

        }

    }


    private static Clas getClass(String className){
        for(int i = 0 ; i < classes.size();i++){

            Clas c = classes.get(i);
            if(c.getName().equals(className))
                return c;

        }

        return null;
    }


}
