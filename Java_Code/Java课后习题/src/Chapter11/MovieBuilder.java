package Chapter11;
import java.util.*;

public class MovieBuilder {
	static String[] a;
	MovieBuilder(){
		a = new String[3];
		a[0] = "StarWars";
		a[1] = "CityOfStars";
		a[2] = "BeforeMidnight";
	}
	public static String[] fill(String[] s){
		for(int i = 0; i < s.length; i++){
			s[i] = a[i % 3];
		}
		return s;
	}
	public static ArrayList fill(ArrayList ar){
		return null;
	}
	public static void main(String[] args){
		MovieBuilder a = new MovieBuilder();
		String[] s = new String[10];
		a.fill(s);
		for(int i = 0; i < 10; i++){
			System.out.println(s[i]);
		}
	}
}
