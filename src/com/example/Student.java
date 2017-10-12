package com.example;

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
    public void parse(String input) {

        String[] studentInfo = input.split(",");

        for(int i = 1 ; i < studentInfo.length;i++){

            String[] keyValue = studentInfo[i].split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            if(key.equalsIgnoreCase("name")){
                setName(value);
            }else if(key.equalsIgnoreCase("seat")){
                setSeatNumber(Integer.parseInt(value));
            }else if(key.equalsIgnoreCase("class")){
                setClassName(value);
            }

        }
    }

    @Override
    public String getOutput() {
        return getName() + " " + getSeatNumber();
    }
}
