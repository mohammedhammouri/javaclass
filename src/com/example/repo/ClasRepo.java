package com.example.repo;


import com.example.Clas;

import java.util.List;

public interface ClasRepo {

    Clas create(Clas Clas);

    Clas update(String id, Clas Clas);

    Clas remove(Clas Clas);

    Clas get(String id);

    List<Clas> getAll();

    List<Clas> query(String clasName,String teacherName);

}
