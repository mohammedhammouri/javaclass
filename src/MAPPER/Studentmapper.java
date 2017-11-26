package MAPPER;
import com.company.*;
import jdk.vm.ci.meta.MemoryAccessProvider;
import java.util.HashMap;

public class Studentmapper implements mapper<HashMap<String,String>,student> {
    //MAPTO RETURN HASHMAP, STORED DATA FROM CLASS TO MAP

    @Override
    public HashMap<String, String> mapTo(student t) {
       HashMap<String,String> map =new HashMap<>();
        map.put("name",t.getName());
        map.put("seat number",t.getSeatNumber());
        map.put("classname",t.name);
       return map;
    }
//MAP RETURN OBJECT(STUDENT) , STORED DATA FROM HASHMAP TO STUDENT

    @Override
    public  student map(HashMap<String, String> hashmap) {
        student s=new student();
        s.setName(hashmap.get("name"));
        s.setSeatNumber(hashmap.get("seatnumber"));
        s.setClassName(hashmap.get("studentName"));
        return s;
    }
}
