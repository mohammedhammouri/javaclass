package repo;
import com.company.clas;

import java.util.List;

public interface ClassRepo {

    clas create (clas clas);
    clas update (String clasname,clas clas);
    clas remove (clas clas);
    clas get(String clasname);
    List <clas> getall();
    List <clas> quary (String clasname,String teacheerName);

}
