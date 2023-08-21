package Chapter13;

public class StringAndInteger {
	public static void main(String[] args){
		long a = System.currentTimeMillis();
		//Java中的String是不可变字符串，即一旦生成，内容不再改变
		String s1 = "abcd";
		String s2 = s1.toUpperCase();
		String s3 = "abc" + "def" + 47;//由StringBuilder作为中间变量
		String s4 = "";
		StringBuilder c = new StringBuilder();
		for(int i = 0; i < 1000; i++){
			c = c.append(i);
		}
		for(int i = 0; i < 1000; i++){
			s4 = s4 + i;//产生大量中间变量
		}
		long b = System.currentTimeMillis();
		//System.out.println(a);
		System.out.println(b - a);
	}
}
