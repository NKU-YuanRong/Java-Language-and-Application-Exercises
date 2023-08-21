package Chapter12;

class TheNumberIsNotBiggerEnough extends Exception{
	public TheNumberIsNotBiggerEnough() {}
	public TheNumberIsNotBiggerEnough(String s){super(s);}
}

public class test05 {
	public static int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	public static void f(int b)throws TheNumberIsNotBiggerEnough{
		if(b < 5){
			throw new TheNumberIsNotBiggerEnough(b + " is smaller than 5");
		}
		System.out.println(b + " is bigger than 5");
	}
	public static void main(String[] args){
		int judge = 1, i = 0;
		while(judge == 1){
			try{
				judge = 0;
				f(a[i]);
			}catch(TheNumberIsNotBiggerEnough t){
				judge = 1;
				System.out.println(t);
				i++;
			}
		}
	}
}
