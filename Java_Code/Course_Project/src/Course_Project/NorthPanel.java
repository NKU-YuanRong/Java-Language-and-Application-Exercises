package Course_Project;

import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.TimeLimitExceededException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel{
	boolean Timing = false;
	Timer timer;
	public JLabel TimeLeast = new JLabel("对手下棋中");
	public NorthPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(TimeLeast);
	}
	public boolean IsTiming(){
		return Timing;
	}
	public void BeginTiming(){
		Timing = true;
		new Thread(){
			public void run(){
				timer = new Timer();
				timer.schedule(new TimingTask(), 1000, 1000);
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				timer.cancel(); 
				timer.purge(); 
				Timing = false;
				TimeLeast.setText("对手下棋中");
				Vars.control.GiveUpChessing();
			}
		}.start();
	}
	public void StopTiming() {
		Timing = false;
		// TODO Auto-generated method stub
		if(timer!=null){
			timer.cancel();
			timer.purge();
		}
		TimeLeast.setText("对手下棋中");
	}
}

class TimingTask extends TimerTask{
	int time = 60;
	public void run() {
		// TODO Auto-generated method stub
		time--;
		Vars.northpanel.TimeLeast.setText("你的回合，剩余时间：" + time + "s");
		Vars.northpanel.repaint();
	}
}