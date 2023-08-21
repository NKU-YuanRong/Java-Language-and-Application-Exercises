package Chapter16;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class test000 {
	public static void main(String[] args){
		JFrame f = new JFrame("DDDDD");
		f.setSize(new Dimension(500, 400));
		f.setLocation(500, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JButton b1 = new JButton("b1");
		final JButton b2 = new JButton("b2");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimeDelayProcess(b2);
			}

			private void TimeDelayProcess(final JButton b2) {
				new Thread(){
					public void run(){
						try{
							System.out.println("进程开始");
							Thread.sleep(1000);
							System.out.println("进程结束");
							SwingUtilities.invokeLater(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									b2.setText("Seted");
								}
							});
						}catch(final InterruptedException e1){
							e1.printStackTrace();
						}
					}
				}.start();
			}
		});
		f.getContentPane().add(b1,BorderLayout.CENTER);
		f.getContentPane().add(b2, BorderLayout.NORTH);
		f.setVisible(true);
	}
}
