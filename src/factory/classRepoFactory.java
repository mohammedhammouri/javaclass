package factory;

import com.company.clas;
import repo.ClassRepo;

import java.util.List;

public class classRepoFactory implements Factory {
    ClassRepo CLASREPO ;
    private boolean test ;

    public void setTest(boolean test) {
        this.test = test;
    }


    public ClassRepo getCLASREPO() {

        if(getCLASREPO()==null)
            if (test)
               ClassRepo getCLASREPO=new




        return CLASREPO;
    }
}