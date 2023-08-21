package Chapter16;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testMultiThread {
	public static void main(String[] args) {
//		Thread t = new Thread(new NoName());
//		t.start();
//		for (int i = 0; i < 3; i++) {
//			final int num = i;
//			new Thread(){
//				public void run(){
//					int j = 10;
//					while(j >= 0){
//						System.out.println("这是第" + num + "个线程, 这是第" + j-- + "个数字");
//					}
//				}
//			}.start();
//		}
//		new SortThread().start();
		ExecutorService exc = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			exc.execute(new Thread(){
				public void run(){
					for (int j = 0; j < 10; j++) {
						System.out.println(j);
					}
				}
			});
		}
	}
}

class SortThread extends Thread{
	public void run(){
		String[] s = {"Tom", "Jerry", "Liu", "Player"};
		LinkedList<String> ls = new LinkedList<String>();
		for (String str : s) {
			ls.add(str);
		}
		Collections.sort(ls);
		while(ls.size() > 0){
			System.out.println(ls.pop());
		}
	}
}

class NoName implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 10;
		while(i >= 0){
			System.out.println("这是第" + i-- + "个数字");
		}
	}
	
}