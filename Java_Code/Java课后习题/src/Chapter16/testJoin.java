package Chapter16;

public class testJoin {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new OutputNumber(1));
		Thread thread2 = new Thread(new OutputNumber(2));
		Thread thread3 = new Thread(new OutputNumber(3));
//		thread1.setPriority(Thread.MAX_PRIORITY);
//		thread2.setPriority(Thread.MAX_PRIORITY);
//		thread3.setPriority(Thread.MIN_PRIORITY + 1);
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The End");
	}
}

class OutputNumber implements Runnable{
	int threadNumber;
	
	public OutputNumber(int threadNumber) {
		super();
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println("Ïß³Ì" + threadNumber + ": " + i);
		}
	}
}