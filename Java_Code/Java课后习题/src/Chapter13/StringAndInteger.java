package Chapter13;

public class StringAndInteger {
	public static void main(String[] args){
		long a = System.currentTimeMillis();
		//Java�е�String�ǲ��ɱ��ַ�������һ�����ɣ����ݲ��ٸı�
		String s1 = "abcd";
		String s2 = s1.toUpperCase();
		String s3 = "abc" + "def" + 47;//��StringBuilder��Ϊ�м����
		String s4 = "";
		StringBuilder c = new StringBuilder();
		for(int i = 0; i < 1000; i++){
			c = c.append(i);
		}
		for(int i = 0; i < 1000; i++){
			s4 = s4 + i;//���������м����
		}
		long b = System.currentTimeMillis();
		//System.out.println(a);
		System.out.println(b - a);
	}
}
