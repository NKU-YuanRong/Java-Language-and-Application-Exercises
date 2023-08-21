package Chapter16;

public class testDeamonThread {
	public static void main(String[] args) {
		final CountThread ct = new CountThread(1);
		ct.setDaemon(true);
		new Thread(){
			public void run(){
				for (int i = 0; i < 1000; i++) {
					System.out.println(ct.getCnt());
				}
			}
		}.start();
		ct.start();
	}
}

class CountThread extends Thread{
	int cnt;
	
	public CountThread(int cnt) {
		super();
		this.cnt = cnt;
	}
	
	

	public int getCnt() {
		return cnt;
	}



	public void setCnt(int cnt) {
		this.cnt = cnt;
	}



	public void run(){
		for (int i = 0; i < 1000; i++) {
			cnt++;
		}
	}
}
