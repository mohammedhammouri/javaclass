package USECASE;
import MAPPER.*;
import com.company.*;

import  java.util.*;

public class CreateClas implements UseCase<HashMap<String,String>,clas> {
    //CREAT NEW CLASS && SET THE VALUE
    @Override
    public clas execute(HashMap<String, String> hashmap) throws Exception {
        clas c=new clas();
        c.setClassName(hashmap.get("name"));
        c.setTeacherName(hashmap.get("teacher name"));
        return c;
    }
}