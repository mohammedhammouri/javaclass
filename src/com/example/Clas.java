package com.example;

public class Clas implements IOParser {


    private String name;
    private String teacherName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void parse(String input) {

        String[] classInfo = input.split(",");

        for(int i = 1 ; i < classInfo.length;i++){
            String[] keyValue = classInfo[i].split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            if(key.equalsIgnoreCase("name")){
                setName(value);
            }else if(key.equalsIgnoreCase("teacherName")){
                setTeacherName(value);
            }
        }



    }

    @Override
    public String getOutput() {
        return getName() + " " + getTeacherName();
    }

}
