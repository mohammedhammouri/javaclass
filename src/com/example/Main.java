package com.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<IOParser> parsers = new ArrayList<>();

    public static void main(String[] args)  {

//        ArrayList<Clas> classes = new ArrayList<>(3);//set initial size of 3 classes better for performance
//        ArrayList<Student> students = new ArrayList<>(10);//set inital size of 10 students this is what we expect
        //better for performance


        askForInput();

        //rinad ssssttttt
        for (int i = 0; i < parsers.size(); i++) {
            IOParser parser = parsers.get(i);
            System.out.println(parser.getOutput());
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
            parsers.add(parser);

            input = scanner.next();

        }

    }


}
