package Free_Test;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
 
class MyTask extends TimerTask{
    public void run() {
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("当前时间：" + format.format(new Date()));    
    }
     
}
 
public class Demo {
 
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 1000);  //1秒后执行，并且每隔100毫秒重复执行
         
        try {
            Thread.sleep(5300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        timer.cancel();  //终止计时器，放弃所有已安排的任务
        timer.purge();
        System.out.println("----------------------");
        //timer.purge();  //释放内存
    }
 
}