package com.example.repo_impl;

import com.example.Clas;
import com.example.repo.ClassesRepo;

import java.util.List;

import static com.example.Main.classes;

public class NetworkClasRepo implements ClassesRepo{
    @Override
    public Clas creat(Clas clas) {
        classes.add(clas);
        return clas;
    }

    @Override
    public Clas update(String name,Clas clas) {
        for (int i=0;i<classes.size();i++){
            if(classes.get(i).getName().equals(name)){
                classes.set(i,clas);
                return clas;

            }

        }return clas;
    }

    @Override
    public Clas remove(Clas clas) {
        classes.remove(clas);
        return clas;
    }

    @Override
    public Clas get(String id) {
        for(Clas clas:classes){
            if (clas.getName().equals(id))
                return clas;
        }
        return null;
    }

    @Override
    public List<Clas> getAll() {
        return classes;
    }

    @Override
    public List<Clas> query(String name, String teacherName) {
        return null;
    }
}
