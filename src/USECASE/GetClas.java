package USECASE;
//import com.company.clas;
//import MAPPER.*;
//import java.util.ArrayList;
//import java.util.List;4

import com.company.clas;
import com.company.student;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class GetClas implements UseCase<String ,clas> {
    List <clas> classes=new ArrayList<>();

    public GetClas(List<clas> classes) {
        this.classes = classes;
    }

    @Override
    public clas execute(String clasname) throws Exception {
        for (int i = 0; i < classes.size(); i++) {
            clas c = classes.get(i);
            if (c.getClassName().equals(clasname))
                return c;


        }throw new  Exception ("no class found");


    }}

