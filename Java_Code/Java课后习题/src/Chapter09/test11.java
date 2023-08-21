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
}//源代码中的Processor接口与Apply类

class StringSwap{
	public String process(String input){
		char[] List = input.toCharArray();
		char temp;
		for(int i = 0; i < List.length; i += 2){
			temp = List[i];
			List[i] = List[i + 1];
			List[i + 1] = temp;
		}
		return String.valueOf(List);//利用valueOf函数将char数组转为String
	}
}//字符串互换类，函数process可将输入字符串每一对字符进行互换

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
}//最关键的Adapter类，StringSwap函数比接口Processor缺少一个name()函数，Adapter类补上了这个函数并将经a互换处理后的String传给process

public class test11 {
	public static String s = "If she weighs the same as a duck, she's made of wood";
	public static void main(String[] args){
		Apply.process(new StringAdapter(new StringSwap()), s);
	}
}
