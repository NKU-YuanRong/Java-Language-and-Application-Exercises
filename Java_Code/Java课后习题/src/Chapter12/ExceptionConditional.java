package Chapter12;
/*
 * 异常不是错误
 * such as:
 * 	试图打开的文件不存在
 * 	数组越界
 *  网络中断等
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
 * 自定义异常
 * 从已经定义的exception类继承，一般继承自Exception类
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
	 * 当出现一个异常：
	 * 1、new方法一个exception对象
	 * 2、中断此程序运行，抛出错误，异常处理机制接管程序
	 * 3、exception handler能否处理exception? 程序继续运行 : 程序中断;
	 * 代码如下：
	 */
	public static void Grammer(String t){
		try{
			if(t == null){
				throw new NullPointerException("t == null");//传递一个字符串给给Exception的构造器
			}//try后写函数体，遇到异常就抛出
		}
		catch(NullPointerException e){
			System.out.println(e);
		}//catch负责处理异常，打括号内写上处理机制
		//catch(Exception Type x){
		//	handle Exception
		
		//}//可以写很多个catch{}处理不同的异常,但是只会运行其中一个
		catch(Exception e){
			System.out.println("Catch an exception: " + e);
		}//甚至可以写一个catch捕捉所有异常
		finally{
			/*
			 * 可以不写
			 * 但只要进入了try，finally一定会被执行
			 */
			System.out.println("function finally() is called");
		}
	}
	
	/*
	 * 异常说明
	 * 一个函数应声明可能抛出的所有异常
	 * void f() throws Exception1, Exception2, Exception3 { ... }
	 */
	
	public static void main(String[] args){
		Grammer(null);
	}
}
