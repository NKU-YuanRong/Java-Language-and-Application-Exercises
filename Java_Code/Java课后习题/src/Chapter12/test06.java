package Chapter12;
import java.util.logging.*;
import java.io.*;

class LoggingException1 extends Exception{
	private static Logger logger = Logger.getLogger("LoggingException1");
	LoggingException1(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

class LoggingException2 extends Exception{
	private static Logger logger = Logger.getLogger("LoggingException2");
	LoggingException2(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
public class test06 {
	public static void main(String[] args){
		try{
			throw new LoggingException1();
		}catch(LoggingException1 l){
			System.err.println("Caught " + l);
		}
		try{
			throw new LoggingException1();
		}catch(LoggingException1 l){
			System.err.println("Caught " + l);
		}
		try{
			throw new LoggingException1();
		}catch(LoggingException1 l){
			System.err.println("Caught " + l);
		}
		try{
			throw new LoggingException2();
		}catch(LoggingException2 l){
			System.err.println("Caught " + l);
		}
		
	}
}
