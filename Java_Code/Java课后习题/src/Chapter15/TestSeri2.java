package Chapter15;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestSeri2 {
	public static void main(String[] args) {
		LinkedList<ArrayList<Person>> to = (LinkedList<ArrayList<Person>>)ReadAndWrite.read();
		System.out.println(to.size());
	}
}
