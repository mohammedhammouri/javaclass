package com.example;

import java.util.Scanner;

public class Student implements IOParser {


    public String name;
    public int seatNumber;
    public String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public void parse(String input) throws WrongDataException,MissingDataException {

        String[] studentInfo = input.split(",");

        int numOfValuesEntered = 0;
        for(int i = 1 ; i < studentInfo.length;i++){

            String[] keyValue = studentInfo[i].split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            if(key.equalsIgnoreCase("name")){
                setName(value);
                numOfValuesEntered++;
            }else if(key.equalsIgnoreCase("seat")){
                setSeatNumber(Integer.parseInt(value));
                numOfValuesEntered++;
            }else if(key.equalsIgnoreCase("class")){
                setClassName(value);
//                Clas c = getClass(value);
//                if(c != null)
//                    c.addStudent(this);

                numOfValuesEntered++;
            }
        }

        if(numOfValuesEntered < 3){
            throw new MissingDataException(3- numOfValuesEntered);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", seatNumber=" + seatNumber +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (seatNumber != student.seatNumber) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return className != null ? className.equals(student.className) : student.className == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + seatNumber;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        return result;
    }

//        private Clas getClass(String className){
//        for(int i = 0 ; i < Main.classes.size();i++){
//
//            IOParser parser = Main.classes.get(i);
//
//            if(parser instanceof Clas){
//
//                Clas c = (Clas) parser;
//                if(c.getName().equals(className))
//                    return c;
//
//            }
//        }
//
//        return null;
//    }


}
