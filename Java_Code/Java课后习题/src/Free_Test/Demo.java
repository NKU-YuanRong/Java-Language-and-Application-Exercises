package Free_Test;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
 
class MyTask extends TimerTask{
    public void run() {
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("��ǰʱ�䣺" + format.format(new Date()));    
    }
     
}
 
public class Demo {
 
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 1000);  //1���ִ�У�����ÿ��100�����ظ�ִ��
         
        try {
            Thread.sleep(5300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        timer.cancel();  //��ֹ��ʱ�������������Ѱ��ŵ�����
        timer.purge();
        System.out.println("----------------------");
        //timer.purge();  //�ͷ��ڴ�
    }
 
}