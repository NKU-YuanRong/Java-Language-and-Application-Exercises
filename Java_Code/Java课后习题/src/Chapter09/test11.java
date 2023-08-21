package Chapter09;

interface Processor{
	String name();
	Object process(Object input);
}
class Apply{
	public static void process(Processor p, Object s){
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
	}
}//Դ�����е�Processor�ӿ���Apply��

class StringSwap{
	public String process(String input){
		char[] List = input.toCharArray();
		char temp;
		for(int i = 0; i < List.length; i += 2){
			temp = List[i];
			List[i] = List[i + 1];
			List[i + 1] = temp;
		}
		return String.valueOf(List);//����valueOf������char����תΪString
	}
}//�ַ��������࣬����process�ɽ������ַ���ÿһ���ַ����л���

class StringAdapter implements Processor{
	StringSwap a;
	public StringAdapter(StringSwap aa){
		a = aa;
	}
	public String name(){
		return a.getClass().getSimpleName();
	}
	public Object process(Object input){
		return a.process((String)input);
	}
}//��ؼ���Adapter�࣬StringSwap�����Ƚӿ�Processorȱ��һ��name()������Adapter�ಹ�����������������a����������String����process

public class test11 {
	public static String s = "If she weighs the same as a duck, she's made of wood";
	public static void main(String[] args){
		Apply.process(new StringAdapter(new StringSwap()), s);
	}
}
