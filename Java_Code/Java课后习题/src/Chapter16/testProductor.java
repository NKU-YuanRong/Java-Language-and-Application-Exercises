package Chapter16;

import java.util.Date;
import java.util.Vector;

public class testProductor {
	public static void main(String[] args) {
		Productor productor = new Productor();
		productor.start();
		new Consumer(productor).start();
	}
}

class Productor extends Thread{
	static final int MAXQUEUE = 5;
	private Vector<String> Messages = new Vector<>();
	public void run(){
		try {
			while(true){
				putMessage();
				sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private synchronized void putMessage() throws InterruptedException {
		while(Messages.size() == MAXQUEUE) wait();
		Messages.add(new Date().toString());
		notify();
	}
	public synchronized String getMessage() throws InterruptedException{
		while(Messages.size() == 0) wait();
		String message = Messages.firstElement();
		Messages.removeElement(message);
		notify();
		return message;
	}
}

class Consumer extends Thread{
	Productor productor;

	public Consumer(Productor productor) {
		super();
		this.productor = productor;
	}
	public void run(){
		try {
			while(true){
				String message = productor.getMessage();
				System.out.println("Get Message: " + message);
				sleep(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}