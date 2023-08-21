package Course_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReadAndWriteHistory {
	private static String FileName = "D:/个人文件/作业/Java/Course_Project/JavaHistory.txt";
	private static File file = new File(FileName);
    public static void write(Serializable s){
        try {
        	if(!file.exists()){
        		file.createNewFile();
        	}
            ObjectOutputStream objectOutputStream = 
            		new ObjectOutputStream(
            				new FileOutputStream(FileName));
            objectOutputStream.writeObject(s);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(){
    	if(!file.exists()){
    		return null;
    	}
        Object obj=null;
        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(FileName));
            obj = input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
