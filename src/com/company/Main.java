package com.company;
import USECASE.*;
import MAPPER.*;
import java.util.*;

import static java.util.Locale.US;

public class Main {

    public static List<clas> classes= new ArrayList<>();
public static List<student>students=new ArrayList<>();


    public static void main(String[] args) {
        GetClas get=new GetClas(classes);
        GetStudent get2=new GetStudent(students);

try {
    get.execute("grade2");
    get.execute("grade3");
    get2.execute("haneen");
    get2.execute("murad");

}catch (Exception e){
    // write your code here
    e.printStackTrace();

    AskForInput();
   classes.get(classes.size());

    for (int i = 0; i < classes.size(); i++) {
        clas c = classes.get(i);
        System.out.println(c);
    }




}
    }
    public static void AskForInput (){
        Scanner s=new Scanner(System.in);
        String Input=s.next();
        while (Input!="done"){

            HashMap<String,String> KeyValue=new HashMap<>();
            String [] info =Input.split(",");
            for (int i=2;i<info.length;i++){

              String [] keyValue=info[i].split(":");
              String key=keyValue[0];
              String value=keyValue[1];
              KeyValue.put(key,value);




            }
        }
    }private static clas getClass(String className) throws NoChasFound {
        for (int i = 0; i < classes.size(); i++) {

            clas c = classes.get(i);
            if (c.getClassName().equals(className))
                return c;

        }

        throw new NoChasFound(className);
    }


}
