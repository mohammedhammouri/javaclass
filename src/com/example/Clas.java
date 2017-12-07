package com.example;

import java.util.List;


/**
 * A class containing a list of {@link Student}
 */
public class Clas {

    private String name;
    private String teacherName;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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


    @Override
    public String toString() {
        return "Clas{" +
                "name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", studentsNames=" + studentsNames +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clas clas = (Clas) o;

        if (name != null ? !name.equals(clas.name) : clas.name != null) return false;
        if (teacherName != null ? !teacherName.equals(clas.teacherName) : clas.teacherName != null) return false;
        return studentsNames != null ? studentsNames.equals(clas.studentsNames) : clas.studentsNames == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (studentsNames != null ? studentsNames.hashCode() : 0);
        return result;
    }
}
