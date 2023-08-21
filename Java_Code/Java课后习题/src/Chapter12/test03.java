package Chapter12;
import java.util.logging.*;
import java.io.*;

public class test03 {
	public static void f(int a[]){
		String s = "";
		for(int i = 0; i < 10; i++){
			s += a[i];
			System.out.println(s);
		}
		System.out.println(s);
	}
	public static void main(String[] args){
		int a[] = new int[5];
		try{
			f(a);
		}
		catch(ArrayIndexOutOfBoundsException e){
			//System.out.println("Out of bounds");
			e.printStackTrace(System.out);
		}
	}
}
