//CD.java
package CDshop;

public class CD {
	private String name;
	private int id;
	private int price;
	private int num;
	public CD(int id, String name, int price, int num){
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void addNum(int number){
		num += number;
	}
	public void sell(int number){
		num -= number;
	}
	public int getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CD [name=" + name + ", id=" + id + ", price=" + price
				+ ", num=" + num + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + price;
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
		CD other = (CD) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
