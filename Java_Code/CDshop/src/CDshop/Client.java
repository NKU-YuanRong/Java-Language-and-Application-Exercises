//Client.java
package CDshop;

public class Client {
	int id;
	String name;
	int balence;
	CDBook hold = new CDBook();
	public Client(int id, String name, int balence) {
		super();
		this.id = id;
		this.name = name;
		this.balence = balence;
		//this.hold = hold;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balence;
	}
	public void addBook(CD d){
		hold.addCD(d);
	}
	public CD returnCD(int id){
		CD temp = hold.findCD(id);
		hold.removeCD(id);
		return temp;
	}
	public void useBalence(int AllPrice){
		balence -= AllPrice;
	}
	public void addBalence(int money){
		balence += money;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "id = " + id + ", name=" + name + ", balance=" + balence + ", " + hold;
	}
	public void printBooks(){
		hold.print();
	}
	
}
