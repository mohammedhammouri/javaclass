package com.company;

import java.util.ArrayList;
import java.util.List;

public class clas {
    private String teacherName;
   private String ClassName;
private List<String> studenName=new ArrayList<String>();
    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
public void AddStudentName(String studetNames){
        studenName.add(studetNames);
}
    public List<String> getStudenName() {
        return studenName;
    }

    public void setStudenName(List<String> studenName) {
        this.studenName = studenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof clas)) return false;

        clas clas = (clas) o;

        if (getTeacherName() != null ? !getTeacherName().equals(clas.getTeacherName()) : clas.getTeacherName() != null)
            return false;
        if (getClassName() != null ? !getClassName().equals(clas.getClassName()) : clas.getClassName() != null)
            return false;
        return getStudenName() != null ? getStudenName().equals(clas.getStudenName()) : clas.getStudenName() == null;
    }

    @Override
    public String toString() {
        return "clas{" +
                "teacherName='" + teacherName + '\'' +
                ", ClassName='" + ClassName + '\'' +
                ", studenName=" + studenName +
                '}';
    }

    @Override
    public int hashCode() {
        int result = getTeacherName() != null ? getTeacherName().hashCode() : 0;
        result = 31 * result + (getClassName() != null ? getClassName().hashCode() : 0);
        result = 31 * result + (getStudenName() != null ? getStudenName().hashCode() : 0);
        return result;
    }
}
