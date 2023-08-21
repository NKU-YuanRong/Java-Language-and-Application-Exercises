package Chapter15;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class SerilizationTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LinkedList<Student> lls = new LinkedList<Student>();
		lls.add(new Student("Lihua", 13, 2012333));
		lls.add(new Student("Cuihua", 30, 2000000));
		lls.add(new Student("Jerry", 3, 0000200));
		SaveData.Save(lls);
		LinkedList<Student> rlls = SaveData.Get();
		while(rlls.size() != 0){
			System.out.println(rlls.pop());
		}
	}
}

class SaveData{
	static String path = "D:/FFOutput/1510Text.txt";
	public static void Save(LinkedList<Student> lls) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(path)));
		out.writeObject(lls);
		out.close();
	}
	public static LinkedList<Student> Get() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(path)));
		return (LinkedList<Student>) in.readObject();
	}
}

class Student implements Serializable{
	private String name;
	private int age;
	private transient int ID;
	public Student(String name, int age, int iD) {
		super();
		this.name = name;
		this.age = age;
		this.ID = iD;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", ID=" + ID + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}