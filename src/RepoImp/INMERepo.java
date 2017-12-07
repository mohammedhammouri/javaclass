package RepoImp;

import com.company.clas;
import repo.ClassRepo;

import java.util.ArrayList;
import java.util.List;

public class INMERepo implements ClassRepo {

    List <clas> classes = new ArrayList<>();
    @Override
    public clas create(clas clas) {
        classes.add(clas);
        return clas;

    }

    @Override
    public clas update(String clasname, clas clas) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getClassName().equals(clasname))
                classes.set(i,clas);
            return clas;
        }
  return clas;  }

    @Override
    public clas remove(clas clas) {
        classes.remove(clas);
        return clas;

    }

    @Override
    public clas get(String clasname,clas clas) {
        for (int i = 0; i < classes.size(); i++) {
           if( classes.get(i).getClassName().equals(clasname))

               return clas;

        }
        return null;
    }

    @Override
    public List<clas> getall() {
        return classes;
    }

    @Override
    public List<clas> quary(String clasname, String teacherName) {
        //select * from clas where classname=""and teacherName=""
        List <clas> finalResult =new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            if(classes.get(i).getClassName().equals(clasname)
                    ||classes.get(i).getTeacherName().equals(teacherName))
                finalResult.add(classes.get(i));



        }

        return finalResult;
    }
}
