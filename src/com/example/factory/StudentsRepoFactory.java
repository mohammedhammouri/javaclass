package com.example.factory;

import com.example.repo.StudentsRepo;
import com.example.repo_impl.InMemeryStudentRepo;

public class StudentsRepoFactory extends BaseFactory<StudentsRepo> {

    private StudentsRepo studentsRepo;

    @Override
    public StudentsRepo get() {
        if(studentsRepo == null) {
                studentsRepo = new InMemeryStudentRepo();
        }
        return studentsRepo;
    }


}

