package factory;

import RepoImp.DBCLASREMPO;
import RepoImp.INMERepo;
import com.company.clas;
import repo.ClassRepo;

import java.util.List;

public class classRepoFactory implements Factory<ClassRepo> {
   private ClassRepo classRepo ;
    private boolean test ;

    public void setTest(boolean test) {
        this.test = test;
    }


    public ClassRepo getCLASREPO() {

        if(getCLASREPO()==null)
            if (test) {
                 classRepo= new INMERepo();
            } else {
               classRepo  = new DBCLASREMPO();
            }






        return classRepo;
    }
}