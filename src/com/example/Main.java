package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayList<Clas> classes = new ArrayList<>(3);//set initial size of 3 classes better for performance
//        ArrayList<Student> students = new ArrayList<>(10);//set inital size of 10 students this is what we expect
        //better for performance

        ArrayList<IOParser> parsers = new ArrayList<>();

        String input = scanner.next();
        while(!input.equals("done")){

            IOParser parser = null;
            if(input.startsWith("c")){
                parser = new Clas();
            }else if(input.startsWith("s")) {
                parser = new Student();
            }

            parser.parse(input);
            parsers.add(parser);

            input = scanner.next();

        }

        for (int i = 0; i < parsers.size(); i++) {
            IOParser parser = parsers.get(i);
            System.out.println(parser.getOutput());
        }


    }
}
