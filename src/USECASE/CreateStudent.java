package USECASE;
import MAPPER.*;
import com.company.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.company.NoChasFound;

public class CreateStudent implements UseCase<HashMap<String,String>,student> {

private  final List<student> students=new ArrayList<>();
    private final Studentmapper studentMapper;
    private final Scanner scanner;
    private final GetClas getClass;
    private final CreateClas createClas;
    private final ClassMappeer clasMapper;
    private Update Update;

    public CreateStudent(Studentmapper studentMapper, Scanner scanner, GetClas getClass, CreateClas createClas, ClassMappeer clasMapper, Update update) {
        this.studentMapper = studentMapper;
        this.scanner = scanner;
        this.getClass = getClass;
        this.createClas = createClas;
        this.clasMapper = clasMapper;
        Update = update;
    }



// CREATE NEW STUDENT IN 3 CASES
    @Override
    public student execute(HashMap<String, String> hashmap) throws Exception {
        student s = studentMapper.map(hashmap);
        if(s.getName()==null)
           // System.out.println("data null");
            throw new wrongDataexception("DATA NULL","NAME");
        if (s.getName().length()<20)
           // System.out.println("wrong data");
            throw new wrongDataexception("name length must be less than 20","name");
        students.add(s);

//   هاد الشي ليه اعملناه ازا هو ضاف STUDENT شو بدنا بالCLASS   <فاهمه الطريقه بس ليه اعملناه>
        clas c = null;
        try {
            c = getClass.execute(s.getClassName);
            c.AddStudentName(s.getName());
            Update.execute(clasMapper.mapTo(c));
        }
            catch(NoChasFound noClasFound ){
            String teachearname=scanner.next();
            clas clas=new clas();
            clas.setTeacherName(teachearname);
            clas.setClassName(noClasFound.getMissingclasname());
                HashMap<String,String> clasData=clasMapper.mapTo(c);
                clas c2=createClas.execute(clasData);
             c2.AddStudentName(s.getName());
          HashMap<String,String> update=clasMapper.mapTo(c);
          Update.execute(update);}
  return s;  }
}
