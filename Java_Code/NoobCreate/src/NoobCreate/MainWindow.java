package NoobCreate;

import javax.swing.*;

import java.awt.*;


public class MainWindow {
	static JFrame Topc = new JFrame("NoobCreate");

	static ToolBar toolbar = new ToolBar();
	static DrawingPanel drawingpanel = new DrawingPanel();
	static PaintersBar paintersbar = new PaintersBar();

	public MainWindow() {

		Topc.setSize(1200, 1000);
		Topc.setLocation(480, 150);
		Topc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Topc.getContentPane().add(toolbar, BorderLayout.NORTH);
		Topc.getContentPane().add(drawingpanel,BorderLayout.CENTER);
		Topc.getContentPane().add(paintersbar, BorderLayout.WEST);
		Topc.setVisible(true);
	}
	public static void main(String[] args){
		new MainWindow();
	}
}

