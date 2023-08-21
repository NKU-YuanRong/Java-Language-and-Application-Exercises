package Chapter12;

class MoneyIsNotEnough extends Exception{
	String lessMoney;
	public MoneyIsNotEnough(){}
	public MoneyIsNotEnough(String s){
		super(s);
		lessMoney = s;
	}//接收字符串参数，用于父类Exception的构造
	@Override
	public String toString() {
		return "MoneyIsNotEnoughException: You need extra " + lessMoney + " dollar to buy it!";
	}
	
}//自定义异常类，该类拥有一个接收字符串参数的构造器

public class test04{
	public static int money = 100;//静态变量money
	
	public static void Buy(int price)throws MoneyIsNotEnough{
		if(money < price){
			throw new MoneyIsNotEnough(String.valueOf(price - money));
		}
		money = money - price;
		System.out.println("Pay Successfully! Balance: " + money);
	}//函数Buy，虚拟购买价格为price的商品，如果余额不足则抛出异常MoneyIsNotEnough
	
	public static void PrintMoneyException(MoneyIsNotEnough m){
		System.out.println(m);
	}//将MoneyIsNotEnough中的字符串显示到屏幕的方法
	
	public static void main(String[] args){
		try{
			Buy(20);//正常运行
			Buy(90);//余额不足，抛出MoneyIsNotEnough
		}catch(MoneyIsNotEnough m){
			PrintMoneyException(m);//catch块中接收MoneyIsNotEnough型异常，并将之输出到屏幕上
		}
	}
}
