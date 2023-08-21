package Chapter16;

public class testSynchronized {
	public static void main(String[] args) {
		TestSynchronizedClass thread1 = new TestSynchronizedClass(1);
		TestSynchronizedClass thread2 = new TestSynchronizedClass(2);
		thread1.start();
		thread2.start();
	}
}

class TestSynchronizedClass extends Thread{
	final int id;
	public TestSynchronizedClass(int id) {
		super();
		this.id = id;
	}
	private static synchronized void printWord(){
		for (int i = 0; i < 6; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	private static void printWord(){
//		for (int i = 0; i < 20; i++) {
//			System.out.println(i);
//		}
//	}
	public void run(){
//		for (int i = 0; i < 100; i++) {
//			printWord(i);
//			System.out.println("From thread" + id);
//		}
//		for (int i = 0; i < 6; i++) {
//			printWord();
//		}
		printWord();
		
	}
}