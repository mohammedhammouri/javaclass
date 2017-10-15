package com.example;

import java.util.List;

public class Clas implements IOParser {

    private String name;
    private String teacherName;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

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


    public void parse(String input) throws Exception{

        String[] classInfo = input.split(",");

        int numOfValuesEntered = 0;

        for(int i = 1 ; i < classInfo.length;i++){
            String[] keyValue = classInfo[i].split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            if(key.equalsIgnoreCase("name")){
                setName(value);

                if(value == null || value.isEmpty()){
                    throw new Exception("Invalid name");
                }

                numOfValuesEntered++;
            }else if(key.equalsIgnoreCase("teacherName")){
                setTeacherName(value);

                if(value == null || value.isEmpty()){
                    throw new Exception("Invalid teacherName");
                }

                numOfValuesEntered++;
            }
        }

        if(numOfValuesEntered < 2){
            throw new Exception("Invalid data");
        }


    }



    @Override
    public String toString() {
        return "Clas{" +
                "name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clas clas = (Clas) o;

        if (name != null ? !name.equals(clas.name) : clas.name != null) return false;
        if (teacherName != null ? !teacherName.equals(clas.teacherName) : clas.teacherName != null)
            return false;
        return students != null ? students.equals(clas.students) : clas.students == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }
}
