package Chapter11;
import java.util.*;

public class SimpleSet {
	public static void main(String[] args){
		Collection<Integer> c = new TreeSet<Integer>();
		for(int i = 0; i < 10; i++){
			c.add(i);
		}
		for(Integer i : c){
			System.out.print(i + ", ");
		}
	}
}
