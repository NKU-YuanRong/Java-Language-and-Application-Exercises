package Chapter15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ReadAndWrite {
	private static ArrayList<Person> alp = new ArrayList<Person>();
	private static String FILE_NAME = "D:/JavaHistory.txt";
    public static void write(Serializable s){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectOutputStream.writeObject(s);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Object read(){
        Object obj = null;
        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
//    public static Object read(){
//        Object obj=null;
//        try {
//            ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
//            obj = input.readObject();
//            while(obj!=null){
//            	alp.add((Person)obj);
//            	obj = input.readObject();
//            }
//            input.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for(int i = 0; i < alp.size(); i++){
//        	System.out.println(alp.get(i).age);
//        }
//        return obj;
//    }
    
}
