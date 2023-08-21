package Chapter16;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FindPrimeNumber {
	public static void main(String[] args){
		ExecutorService exec = Executors.newFixedThreadPool(3);
		exec.execute(new Find(0));
		exec.execute(new Find(1));
		exec.execute(new Find(2));
	}
}

class Find implements Runnable{
	int order;
	Find(int ord){
		order = ord;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		FindNumber(1 + order * 1000, 1000 + order * 1000, order);
	}
	
	static void FindNumber(int begin, int end, int ThreadNumber){
		if(begin > end){
			System.out.println("Wrong Input!");
			return;
		}
		boolean judge;
		for(int i = begin; i <= end; i++){
			judge = true;
			for(int j = 2; j <= Math.sqrt(i); j++){
				if(i % j == 0){
					judge = false;
					break;
				}
			}
			if(judge){
				System.out.println("Thread-" + ThreadNumber + ": " + i);
			}
		}
	}
}