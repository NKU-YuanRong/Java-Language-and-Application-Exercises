package Chapter11;
import java.util.*;

public class Gerbil {
	int gerbilNumber;
	Gerbil(int i){
		gerbilNumber = i;
	}
	void hop(){
		System.out.println("Gerbil " + gerbilNumber + " is hoping.");
	}
	public static void main(String[] args){
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		for(int i = 0; i < 20; i++){
			gerbils.add(new Gerbil(i));
		}
		for(Gerbil s : gerbils){
			s.hop();
		}
	}
}


