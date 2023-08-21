package Chapter12;
class MyException1 extends Exception{
	MyException1(String s){super(s);}
}
class MyException2 extends Exception{
	MyException2(String s){super(s);}
}
class MyException3 extends Exception{
	MyException3(String s){super(s);}
}

public class test09 {
	public static void f(int i)throws MyException1, MyException2, MyException3{
		if(i == 1)
		throw new MyException1("MyException1 is Throwed");
		if(i == 2)
		throw new MyException2("MyException2 is Throwed");
		if(i == 3)
		throw new MyException3("MyException3 is Throwed");
	}
	public static void main(String[] args){
		try{
			f(1);//f(2); f(3);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
