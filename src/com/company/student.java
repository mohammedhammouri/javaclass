package com.company;



import org.omg.CORBA.PUBLIC_MEMBER;

public class student {
    public String name;
   public String seatNumber ;
    public String getClassName;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {

        return getClassName;

    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", getClassName='" + getClassName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof student)) return false;

        student student = (student) o;

        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getSeatNumber() != null ? !getSeatNumber().equals(student.getSeatNumber()) : student.getSeatNumber() != null)
            return false;
        return getClassName != null ? getClassName.equals(student.getClassName) : student.getClassName == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSeatNumber() != null ? getSeatNumber().hashCode() : 0);
        result = 31 * result + (getClassName != null ? getClassName.hashCode() : 0);
        return result;
    }

    public void setClassName(String className) {
        this.getClassName = className;
    }
}
