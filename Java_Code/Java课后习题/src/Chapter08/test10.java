package Chapter08;
import Chapter08.Animal;

/*
class Animal{
	void behaviour(){
		move();
	}
	void move(){
		System.out.println("Move!");//move()���������"Move!"
	}
}//Animal�࣬����behaviour()��move()����������behaviour()�п��Ե���move()
*/

class Bird extends Animal{
	void move(){
		System.out.println("Fly!");
	}
}//Animal��ĵ����࣬�ڴ����н�move()����Ϊ���"Fly!"

public class test10 {
	public static void main(String[] args){
		Animal a = new Bird();
		a.behaviour();
	}
}//��a������ת�Ͳ����÷���1ʱ�����������"Fly!"
//��Ϊһ������������ԣ�����ϣ��Java�ڶ�̬�п����޸�һ���ִ��������������������ƻ���ͬʱʹ��������������չ�ԺͿɶ��ԡ�
//Java���Ժܺõ��������������ԣ���̬�ɹ�ʵ���ˡ���Ҫ�ı�Ĳ����벻�ı�Ĳ��ַ��롱��һ��Ҫ����
