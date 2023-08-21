//CDBook.java
package CDshop;
import java.util.*;

public class CDBook {
	private LinkedList<CD> Book;
	public CDBook() {
		super();
		Book = new LinkedList<CD>();
	}
	public void addCD(CD d){
		boolean sameCD = Book.contains(d);
		if(sameCD){
			Book.get(Book.indexOf(d)).addNum(d.getNum());
		}
		else{
			Book.add(d);
		}
	}
	public void print(){
		for(CD d : Book){
			System.out.println(d);
		}
	}
	public boolean removeCD(int id){
		CD d = new CD(id,"",0,0);
		return Book.remove(d);
	}
	public String toString(){
		String result = "AllCDs: \n";
		for(CD d : Book){
			result += d;
			result += "\n";
		}
		return result;
	}
	public String CDname(int id){
		return findCD(id).getName();
	}
	public int CDprice(int id){
		return findCD(id).getPrice();
	}
	public CD findCD(int id){
		return Book.get(Book.indexOf(new CD(id,"",0,0)));
	}
	public int CDnum(int id){
		if(Book.contains(new CD(id,"",0,0))){
			return findCD(id).getNum();
		}
		else{
			return 0;
		}
	}
	public void sellCD(int id, int num){
			findCD(id).sell(num);
	}
	public int GetPrice(int id){
		if(Book.contains(new CD(id,"",0,0))){
			return findCD(id).getPrice();
		}
		else{
			return -1;
		}
	}
}
