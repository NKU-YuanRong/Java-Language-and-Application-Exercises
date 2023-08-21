package Chapter16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreading {
	/*
	 * �߳���һ���Ƚ��̣����򣩸�С�Ķ�ִ�е�Ԫ
	 * һ���߳���һ��������ִ�и��壬�����Լ�����ںͳ��ڣ���������ʧ�Ĺ���
	 * ÿ���߳�ӵ�ж���������ջ�ͳ��������
	 * �̲߳��ܶ������ڣ����������һ������
	 * 
	 * ����̣��ڲ���ϵͳ�У���ͬʱ���ж������
	 * ���̣߳���ͬһ�������У�����߳�ͬʱ���У����ڿ����ݣ�
	 * 
	 * 
	 * �߳̾���һ���������ǿ���дһ��ʵ��Runnable�ӿڵ��࣬Ȼ����run()������ʵ�����ǵ�����
	 * �������øո�д�õ�������Ϊ�������������һ��Thread���̣߳�����t����������װ�ص���t�߳��У�����t.start()�����������߳�
	 * 		����Ȼ�ˣ�Ҳ����ֱ��new��
	 * 
	 */
	
	public static void main(String[] args){
		
		
		
		/*
		 * ����һ���߳������ַ���
		 * 1���̳�Thread�ಢ��дpublic void run()��������Ҫnewһ��Thread�����������̣߳�
		 * 2��ʵ��Runnable�ӿڣ�ʵ��public void run()����
		 * 3��ʹ��Excutor
		 */
		Thread t = new Thread(new LiftOFF());
		t.start();//��1���Ƚ���
		
		new Thread(){
			public void run(){
				
			}
		}.start();//��ѹ���ʵ��
		
		ExecutorService exec = Executors.newCachedThreadPool();//���������߳�
		exec.execute(new LiftOFF());//��exec��ע������
		
		ExecutorService exec1 = Executors.newFixedThreadPool(3);//�̶������߳�
		exec1.execute(new LiftOFF());//��exec1��ע������
		
		
		/*
		 * �������з���ֵ
		 */
		
		/*
		 * �̵߳����ȼ�
		 * ���ֱ�ʾ����Χ1~10
		 * Thread������������
		 * 	Thread.MIN_PRIORITY = 1
		 * 	Thread.NORM_PRIORITY = 5
		 * 	Thread.MAX_PRIORITY = 10
		 * 
		 * һ���̵߳�ȱʡ���ȼ���5����Thread.NORM_PRIORITY
		 * 
		 * CPU�ᰴ���߳����ȼ���ִ���߳�
		 * �߳̿���ͨ��getPriority��setPriority����ȡ��ı��߳�
		 * yield()���������ó�CPU
		 * 
		 * 
		 */
		
		
		/*
		 * Deamon�߳�
		 * Ϊ��̨�̣߳�Ϊ�����̷߳���
		 * isDeamon()
		 * setDeamon()
		 * setDeamon()��Ҫ��start()֮ǰ���ã���Ȼ�ˣ������߳���new�������߳��Զ���Ϊ�Ǿ����߳�
		 * �����߳̽��������̻߳��Զ���ϵͳ����
		 */
		
		/*
		 * joinһ���߳�
		 * 
		 */
		
		/*
		 * ���߳�֮����Դ����
		 * 	���߳�ͬʱʹ��һ����Դʱ���ܲ�����ͻ
		 * 	һһ�Թ������ݷ��ʵĲ����Ĳ�������
		 * 
		 * synchronized�ؼ��ֱ�֤�������ݲ�����������
		 * 	��ʵ�ϣ�ÿ�����󶼺��е�һ�ġ��������
		 * 	�̵߳���synchronized����ʱ���˶��󱻼���
		 * 	����̱߳����������������ȴ�synchronized�����������ɽ�������
		 * 	һ���̶߳�ν���synchronized������������+1���뿪����-1
		 * 	������Ϊ0ʱ��������ȫ�ͷ�
		 * 
		 * �÷���
		 * 	����
		 * 	public synchronized void run()
		 *  public synchronized void synchTest()
		 *  synchronized�ؼ������εĲ��֣�����ռ�õı��������ᱻ����synchronized���ε��̷߳���
		 */
		
		/*
		 * ʹ��Lock����
		 * ReentrantLock lock = new ReentrantLock()
		 * lock.lock();����
		 * һ���̵߳���lock()��������߳��Ѿ�ʹ��lock(),����̻߳ᱻ��ϣ���������ִ�У��ٴ˵ȴ���
		 * boolean success = lock.tryLock()�ж��Ƿ񱻱���߳�������������������false
		 * boolean success = lock.tryLock(2,TimeUnit.SECOND)�ж��Ƿ񱻱���߳�������������������false
		 * lock.unlock()����
		 */
		
		/*
		 * ThreadLocal�̱߳��ش洢
		 * Ŀ�ģ�����Ա����ĵĹ���
		 * �ֶΣ�Ϊʹ����ͬ�����Ĳ�ͬ�̴߳�����ͬ�洢�ռ�
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