package Chapter16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreading {
	/*
	 * 线程是一个比进程（程序）更小的二执行单元
	 * 一个线程是一个独立的执行个体，具有自己的入口和出口，产生和消失的过程
	 * 每个线程拥有独立的运行栈和程序计数器
	 * 线程不能独立存在，必须存在于一进程中
	 * 
	 * 多进程：在操作系统中，能同时运行多个任务
	 * 多线程：在同一个进程中，多个线程同时运行（本节课内容）
	 * 
	 * 
	 * 线程就是一个任务，我们可以写一个实现Runnable接口的类，然后在run()函数中实现我们的任务
	 * 接下来用刚刚写好的任务作为构造参数来构造一个Thread（线程）对象t，即将任务装载到了t线程中，调用t.start()函数来启动线程
	 * 		（当然了，也可以直接new）
	 * 
	 */
	
	public static void main(String[] args){
		
		
		
		/*
		 * 创建一个线程有三种方法
		 * 1、继承Thread类并重写public void run()函数（需要new一个Thread对象来启动线程）
		 * 2、实现Runnable接口，实现public void run()函数
		 * 3、使用Excutor
		 */
		Thread t = new Thread(new LiftOFF());
		t.start();//法1，比较慢
		
		new Thread(){
			public void run(){
				
			}
		}.start();//最佳工程实践
		
		ExecutorService exec = Executors.newCachedThreadPool();//不定数量线程
		exec.execute(new LiftOFF());//向exec中注入任务
		
		ExecutorService exec1 = Executors.newFixedThreadPool(3);//固定数量线程
		exec1.execute(new LiftOFF());//向exec1中注入任务
		
		
		/*
		 * 从任务中返回值
		 */
		
		/*
		 * 线程的优先级
		 * 数字表示；范围1~10
		 * Thread中三个常量：
		 * 	Thread.MIN_PRIORITY = 1
		 * 	Thread.NORM_PRIORITY = 5
		 * 	Thread.MAX_PRIORITY = 10
		 * 
		 * 一个线程的缺省优先级是5，即Thread.NORM_PRIORITY
		 * 
		 * CPU会按照线程优先级来执行线程
		 * 线程可以通过getPriority和setPriority来获取或改变线程
		 * yield()函数主动让出CPU
		 * 
		 * 
		 */
		
		
		/*
		 * Deamon线程
		 * 为后台线程，为其他线程服务
		 * isDeamon()
		 * setDeamon()
		 * setDeamon()需要在start()之前调用，当然了，精灵线程中new出来的线程自动认为是精灵线程
		 * 在主线程结束后精灵线程会自动被系统结束
		 */
		
		/*
		 * join一个线程
		 * 
		 */
		
		/*
		 * 多线程之间资源共享
		 * 	多线程同时使用一个资源时可能产生冲突
		 * 	一一对共享数据访问的操作的不完整性
		 * 
		 * synchronized关键字保证共享数据操作的完整性
		 * 	事实上，每个对象都含有单一的“锁”标记
		 * 	线程调用synchronized方法时，此对象被加锁
		 * 	如果线程被其他对象加锁，需等待synchronized方法结束方可解锁访问
		 * 	一个线程多次进入synchronized方法，锁计数+1，离开方法-1
		 * 	锁计数为0时，锁被完全释放
		 * 
		 * 用法：
		 * 	修饰
		 * 	public synchronized void run()
		 *  public synchronized void synchTest()
		 *  synchronized关键字修饰的部分，里面占用的变量将不会被其他synchronized修饰的线程访问
		 */
		
		/*
		 * 使用Lock对象
		 * ReentrantLock lock = new ReentrantLock()
		 * lock.lock();锁定
		 * 一个线程调用lock()后，若别的线程已经使用lock(),则该线程会被阻断（程序不往下执行，再此等待）
		 * boolean success = lock.tryLock()判断是否被别的线程锁定，若被锁定返回false
		 * boolean success = lock.tryLock(2,TimeUnit.SECOND)判断是否被别的线程锁定，若被锁定返回false
		 * lock.unlock()解锁
		 */
		
		/*
		 * ThreadLocal线程本地存储
		 * 目的：避免对变量的的共享
		 * 手段：为使用相同变量的不同线程创建不同存储空间
		 * 
		 * private static ThreadLocal<Integer> tl = new ThreadLocal<>();
		 * 
		 */
		
		/*
		 * CountDownLatch
		 * 		CountDownLatch cdl = new CountDownLatch(N);
		 * 		cdl.await();
		 * 		cdl.countDown();
		 */
	}
}

class LiftOFF implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}