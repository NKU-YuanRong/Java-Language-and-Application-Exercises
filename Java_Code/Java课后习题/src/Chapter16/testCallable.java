package Chapter16;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class testCallable {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TaskWithResult implements Callable<String>{
	private int id;
	
	public TaskWithResult(int id) {
		super();
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of TaskWithResult: " + id;
	}
	
}