package Chapter12;

class MoneyIsNotEnough extends Exception{
	String lessMoney;
	public MoneyIsNotEnough(){}
	public MoneyIsNotEnough(String s){
		super(s);
		lessMoney = s;
	}//�����ַ������������ڸ���Exception�Ĺ���
	@Override
	public String toString() {
		return "MoneyIsNotEnoughException: You need extra " + lessMoney + " dollar to buy it!";
	}
	
}//�Զ����쳣�࣬����ӵ��һ�������ַ��������Ĺ�����

public class test04{
	public static int money = 100;//��̬����money
	
	public static void Buy(int price)throws MoneyIsNotEnough{
		if(money < price){
			throw new MoneyIsNotEnough(String.valueOf(price - money));
		}
		money = money - price;
		System.out.println("Pay Successfully! Balance: " + money);
	}//����Buy�����⹺��۸�Ϊprice����Ʒ������������׳��쳣MoneyIsNotEnough
	
	public static void PrintMoneyException(MoneyIsNotEnough m){
		System.out.println(m);
	}//��MoneyIsNotEnough�е��ַ�����ʾ����Ļ�ķ���
	
	public static void main(String[] args){
		try{
			Buy(20);//��������
			Buy(90);//���㣬�׳�MoneyIsNotEnough
		}catch(MoneyIsNotEnough m){
			PrintMoneyException(m);//catch���н���MoneyIsNotEnough���쳣������֮�������Ļ��
		}
	}
}
