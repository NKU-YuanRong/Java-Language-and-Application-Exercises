//ClientBook.java
package CDshop;
import java.util.*;

public class ClientBook {
	private LinkedList<Client> Data = new LinkedList<Client>();
	public void addClient(Client c){
		Data.add(c);
	}
	public boolean removeClient(int id){
		return Data.remove(new Client(id," ",0));
	}
	public String toString() {
		String result = "AllCllients :\n";
		for(Client c : Data){
			result += c;
		}
		return result;
	}
	public void addCD(int id, CD d){
		Data.get(Data.indexOf(new Client(id,"",0))).addBook(d);
	}
	public CD returnCD(int ClId, int CDid){
		return Data.get(Data.indexOf(new Client(ClId,"",0))).returnCD(CDid);
	}
	public void printBook(int id){
		Data.get(Data.indexOf(new Client(id,"",0))).printBooks();
	}
	public int getBalence(int id){
		return Data.get(Data.indexOf(new Client(id,"",0))).getBalance();
	}
	public void pay(int id, int AllPrice){
		Data.get(Data.indexOf(new Client(id,"",0))).useBalence(AllPrice);
	}
	public boolean findClient(int id){
		return Data.contains(new Client(id,"",0));
	}
	public static void main(String[] args){
		ClientBook a = new ClientBook();
		a.addClient(new Client(1,"bob",100));
		a.addClient(new Client(2,"jessy",100));
		a.addClient(new Client(3,"asdfasdf",100));
		a.addCD(1, new CD(1, "abc", 10, 1));
		//a.printBook(2);
		System.out.println(a);
		
	}
	
}

