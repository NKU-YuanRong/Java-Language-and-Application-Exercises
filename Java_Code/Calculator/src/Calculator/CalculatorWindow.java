package Calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorWindow {
	static JFrame frame = new JFrame("Calculator");//���������ڣ���������
	static JPanel tapper = new JPanel();//����������
	static JTextField display = new JTextField();//�ı���ʾ����ʽ��ʾ������
	static String disText = "";//��Ļ��ʾ���ַ�����������ʽ�ӣ�
	
	static JButton B7 = new JButton("7");
	static JButton B8 = new JButton("8");
	static JButton B9 = new JButton("9");
	static JButton Bmul = new JButton("*");
	static JButton B4 = new JButton("4");
	static JButton B5 = new JButton("5");
	static JButton B6 = new JButton("6");
	static JButton Bmin = new JButton("-");
	static JButton B1 = new JButton("1");
	static JButton B2 = new JButton("2");
	static JButton B3 = new JButton("3");
	static JButton Bp = new JButton("+");
	static JButton BC = new JButton("C");
	static JButton B0 = new JButton("0");
	static JButton Bd = new JButton("��");
	static JButton Be = new JButton("=");
	static JButton Blb = new JButton("(");
	static JButton Brb = new JButton(")");
	static JButton Bz = new JButton("%");
	static JButton Bpo = new JButton(".");
	//���ü�������ť
	
	public static void main(String[] args){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setLocation(800, 400);
		frame.setResizable(false);
		//��frame����

		
		display.setSize(new Dimension(400, 100));
		display.setText(disText);
		display.setEditable(false);
		//display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setFont(new Font("TimesNewRoman",Font.BOLD,60));
		//��display����
		
		tapper.setLayout(new GridLayout(5,4));
		//ʹ��GridLayout������򲼾�
		
		Font f = new Font("TimesNewRoman",Font.BOLD,40);
		B7.setFont(f);
		B8.setFont(f);
		B9.setFont(f);
		Bmul.setFont(f);
		B4.setFont(f);
		B5.setFont(f);
		B6.setFont(f);
		Bmin.setFont(f);
		B1.setFont(f);
		B2.setFont(f);
		B3.setFont(f);
		Bp.setFont(f);
		BC.setFont(f);
		B0.setFont(f);
		Bd.setFont(f);
		Be.setFont(f);
		Blb.setFont(f);
		Brb.setFont(f);
		Bz.setFont(f);
		Bpo.setFont(f);
		//��ÿ����ť��������
		
		NumberButtonProcess BtnPro = new NumberButtonProcess();
		B7.addActionListener(BtnPro);
		B8.addActionListener(BtnPro);
		B9.addActionListener(BtnPro);
		B4.addActionListener(BtnPro);
		B5.addActionListener(BtnPro);
		B6.addActionListener(BtnPro);
		B1.addActionListener(BtnPro);
		B2.addActionListener(BtnPro);
		B3.addActionListener(BtnPro);
		B0.addActionListener(BtnPro);
		Blb.addActionListener(BtnPro);
		Brb.addActionListener(BtnPro);
		Bpo.addActionListener(BtnPro);
		//��ÿ�����ְ�ť�Ҽ���
		
		SighButtonProcess SiBtnPro = new SighButtonProcess();
		Bmul.addActionListener(SiBtnPro);
		Bmin.addActionListener(SiBtnPro);
		Bp.addActionListener(SiBtnPro);
		Bd.addActionListener(SiBtnPro);
		Bz.addActionListener(SiBtnPro);
		//��ÿ���������ť�Ҽ���
		
		EqualButtonProcess EqBtnPro = new EqualButtonProcess();
		Be.addActionListener(EqBtnPro);
		//��'='��ť�Ҽ���
		
		CButtonProcess CBtnPro = new CButtonProcess();
		BC.addActionListener(CBtnPro);
		//�����㰴ť�Ҽ���
		
		tapper.add(Blb);
		tapper.add(Brb);
		tapper.add(Bz);
		tapper.add(Bd);
		tapper.add(B7);
		tapper.add(B8);
		tapper.add(B9);
		tapper.add(Bmul);
		tapper.add(B4);
		tapper.add(B5);
		tapper.add(B6);
		tapper.add(Bmin);
		tapper.add(B1);
		tapper.add(B2);
		tapper.add(B3);
		tapper.add(Bp);
		tapper.add(BC);
		tapper.add(B0);
		tapper.add(Bpo);
		tapper.add(Be);
		//����ť���ֵ�������
		
		frame.getContentPane().add(tapper,BorderLayout.CENTER);
		frame.getContentPane().add(display,BorderLayout.NORTH);
		frame.setVisible(true);
		//��ʾTopContainer,��ʼ����
	}
}

class NumberButtonProcess implements ActionListener{
	//ʵ�����ְ�ť������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CalculatorWindow.disText += e.getActionCommand();
		CalculatorWindow.display.setText(CalculatorWindow.disText);
	}
}

class SighButtonProcess implements ActionListener{
	//ʵ���������ť������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CalculatorWindow.disText += e.getActionCommand();
		CalculatorWindow.display.setText(CalculatorWindow.disText);
	}
}

class EqualButtonProcess implements ActionListener{
	//ʵ��'='��ť������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = Calcu.CalcuUnit(CalculatorWindow.disText);
		CalculatorWindow.disText = result;
		CalculatorWindow.display.setText(CalculatorWindow.disText);
	}
}

class CButtonProcess implements ActionListener{
	//ʵ�����㰴ť������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CalculatorWindow.disText = "";
		CalculatorWindow.display.setText(CalculatorWindow.disText);
	}
	
}