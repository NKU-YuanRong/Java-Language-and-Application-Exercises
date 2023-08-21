package Chapter15;

import java.util.ArrayList;
import java.util.LinkedList;

public class testSeri {
	public static void main(String[] args) {
//		Person p = new Person(3, 15);
//		ReadAndWrite.write(p);
//		
//		
//		Person d = (Person)ReadAndWrite.read();
//		System.out.println(d.age + " " + d.height);
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person(3, 15));
		list.add(new Person(5, 18));
		list.add(new Person(17, 6));
		ArrayList<Person> list2 = new ArrayList<Person>();
		list2.add(new Person(5, 11));
		list2.add(new Person(90, 28));
		list2.add(new Person(17, 63));
		list2 = new ArrayList<Person>();
		
		LinkedList<ArrayList<Person>> Total = new LinkedList<ArrayList<Person>>();
		Total.add(list);
		Total.add(list2);
		//list2.removeAll(null);
//		ReadAndWrite.write(list);
//		ReadAndWrite.write(list2);
		ReadAndWrite.write(Total);
		//list2.removeAll(null);
		
//		ArrayList<Person> al = (ArrayList<Person>)ReadAndWrite.read();
		//System.out.println(al);
		//ArrayList<Person> al2 = (ArrayList<Person>)ReadAndWrite.read();
//		System.out.println(al.get(1).age + " " + al.get(2).height);
		//System.out.println(al2.get(1).age + " " + al2.get(2).height);
		//LinkedList<ArrayList<Person>> to = (LinkedList<ArrayList<Person>>)ReadAndWrite.read();
		//System.out.println(to.get(1).get(1).height);
	}
}
