package com.example.factory;

import com.example.repo.StudentsRepo;
import com.example.repo_impl.InMemeryStudentRepo;
import com.example.repo_impl.NetworkStudentRepo;

public class StudentsRepoFactory implements Factory<StudentsRepo> {

    private StudentsRepo studentsRepo;
    private boolean test;
    //unit testing


    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public StudentsRepo get() {
        if(studentsRepo == null) {
            if(!test)
                studentsRepo = new NetworkStudentRepo();
            else
                studentsRepo = new InMemeryStudentRepo();
        }
        return studentsRepo;
    }


}

