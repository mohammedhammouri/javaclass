package USECASE;

import com.company.*;

import java.util.ArrayList;
import java.util.List;

import MAPPER.*;
import java.util.ArrayList;
import java.util.List;

public class GetStudent implements UseCase<String,student>{
    List<student> students=new ArrayList<>();

    public GetStudent(List<student> studends) {
        this.students = students;
    }

    @Override
    public student execute(String name) throws Exception{
        for (int i=0;i<students.size();i++ ){
            if(name!=null)
                System.out.println("null Data");
            student s=students.get(i);
            if (s.name.equals(name))
                return s;

        }throw new Exception("student not found");
    }

}
