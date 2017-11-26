package MAPPER;
import com.company.*;
import java.util.HashMap;
import USECASE.*;

public class ClassMappeer implements mapper<HashMap<String,String>,clas> {
    //MAP TO : RETURN HASH MAP ,STORED DATA FROM CLASS TO HASHMAP
    @Override
    public  HashMap<String, String> mapTo(clas t) {
        HashMap<String,String> map=new HashMap<>();
        map.put("name",t.getClassName());
        map.put("teacher name",t.getTeacherName());
        return map;

    }
//MAP RETURN OBJECT(CLAS) , STORED DATA FROM HASHMAP TO CLASS
    @Override
    public  clas map(HashMap<String, String> hashmap) {
        clas c=new clas();
        c.setClassName(hashmap.get("name"));
        c.setTeacherName(hashmap.get("teacher name"));
          return c;
    }
}
