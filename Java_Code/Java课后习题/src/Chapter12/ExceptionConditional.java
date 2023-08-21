package Chapter12;
/*
 * �쳣���Ǵ���
 * such as:
 * 	��ͼ�򿪵��ļ�������
 * 	����Խ��
 *  �����жϵ�
 */
import java.util.logging.*;
import java.io.*;
class LoggingException extends Exception{
	private static Logger logger = Logger.getLogger("LoggingException");
	LoggingException(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

/*
 * �Զ����쳣
 * ���Ѿ������exception��̳У�һ��̳���Exception��
 */
class MyException extends Exception{
	public MyException() {}
	public MyException(String s){super(s);}
	public String getMessage(){
		return "Detail Message: " + super.getMessage();
	}
}


public class ExceptionConditional {
	/*
	 * ������һ���쳣��
	 * 1��new����һ��exception����
	 * 2���жϴ˳������У��׳������쳣������ƽӹܳ���
	 * 3��exception handler�ܷ���exception? ����������� : �����ж�;
	 * �������£�
	 */
	public static void Grammer(String t){
		try{
			if(t == null){
				throw new NullPointerException("t == null");//����һ���ַ�������Exception�Ĺ�����
			}//try��д�����壬�����쳣���׳�
		}
		catch(NullPointerException e){
			System.out.println(e);
		}//catch�������쳣����������д�ϴ������
		//catch(Exception Type x){
		//	handle Exception
		
		//}//����д�ܶ��catch{}����ͬ���쳣,����ֻ����������һ��
		catch(Exception e){
			System.out.println("Catch an exception: " + e);
		}//��������дһ��catch��׽�����쳣
		finally{
			/*
			 * ���Բ�д
			 * ��ֻҪ������try��finallyһ���ᱻִ��
			 */
			System.out.println("function finally() is called");
		}
	}
	
	/*
	 * �쳣˵��
	 * һ������Ӧ���������׳��������쳣
	 * void f() throws Exception1, Exception2, Exception3 { ... }
	 */
	
	public static void main(String[] args){
		Grammer(null);
	}
}
