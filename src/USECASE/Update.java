package USECASE;
import MAPPER.ClassMappeer;
import com.company.clas;
import java.util.HashMap;
import java.util.List;
public class Update implements UseCase<HashMap<String ,String>,clas> {
    private ClassMappeer clasMapper;
    public List<clas> classes;

    public Update(ClassMappeer clasMapper,List<clas> classes) {
        this.clasMapper = clasMapper;
        this.classes = classes;


    }


    @Override
    public clas execute(HashMap<String,String> hashMap) throws Exception {
        clas clas = clasMapper.map(hashMap);
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getClassName().equals(clas.getClassName())) {
                classes.set(i, clas);
                break;
            }
        } return clas;
    }}