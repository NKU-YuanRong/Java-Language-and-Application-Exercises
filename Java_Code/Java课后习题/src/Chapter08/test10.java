package Chapter08;
import Chapter08.Animal;

/*
class Animal{
	void behaviour(){
		move();
	}
	void move(){
		System.out.println("Move!");//move()函数，输出"Move!"
	}
}//Animal类，包含behaviour()和move()两个方法，behaviour()中可以调用move()
*/

class Bird extends Animal{
	void move(){
		System.out.println("Fly!");
	}
}//Animal类的导出类，在此类中将move()重载为输出"Fly!"

public class test10 {
	public static void main(String[] args){
		Animal a = new Bird();
		a.behaviour();
	}
}//在a中向上转型并调用方法1时，最终输出了"Fly!"
//作为一种面向对象语言，我们希望Java在多态中可以修改一部分代码而不对其他部分造成破坏，同时使代码具有优秀的延展性和可读性。
//Java语言很好地满足了这项特性，多态成功实现了“将要改变的部分与不改变的部分分离”这一重要特性
