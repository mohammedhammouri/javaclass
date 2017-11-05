package com.example.usecase;

import com.example.Clas;
import com.example.Student;

import java.util.List;

/**
 *
 */
public class GetStudent implements UseCase<String,Student> {

    private final List<Student> students;

    public GetStudent(List<Student> students) {
        this.students = students;
    }

    /**
     * Some explanation
     * @param s student name
     * @return a student with the given name
     * @throws Exception if student not found
     */
    @Override
    public Student execute(String s) throws Exception {
        if(s == null || s.isEmpty())
            throw new Exception("Null data");

        for (int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if(st.getName().equals(s)){
                return st;
            }
        }



//        for (int i = 0; i < classes.size(); i++) {
//            Clas c = classes.get(i);
//
//            for (int j = 0; j < c.getStudents().size(); j++) {
//               Student student = c.getStudents().get(j);
//               if(student.getName().equals(s))
//                   return student;
//            }
//
//        }


        throw new Exception("No student found");
    }



}
