package com.example.repo;

import com.example.Clas;

import java.util.List;

public interface ClassesRepo {
Clas creat(Clas clas);
Clas update(String name,Clas clas);
Clas remove(Clas clas);
Clas get(String id);
List<Clas> getAll();
List<Clas> query(String name,String teacherName);
}
