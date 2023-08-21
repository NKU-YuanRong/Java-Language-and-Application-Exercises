package NoobCreate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	static int sx,sy,ex,ey;
	//static LinkedList<EveryGra> HisGra = new LinkedList<>();
	static ArrayList<EveryGra> HisGra = new ArrayList<>();
	
	public static void UndoLast(){
		if(HisGra.size()==0)return;
		HisGra.remove(HisGra.size()-1);
	}

	public DrawingPanel() {
		super();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				sx = e.getX();
				sy = e.getY();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				ex = e.getX();
				ey = e.getY();
				repaint();
				HisGra.add(new EveryGra(ControlCenter.getPainterShape(), ControlCenter.getShapeColor(), 
						ControlCenter.isFillShape(), sx, sy, ex, ey, ControlCenter.getDrawingText(), 
						new Font("TimesNewRoman",Font.BOLD,ControlCenter.getTextSize())));
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				ex = e.getX();
				ey = e.getY();
				repaint();
			}
		});
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		setBackground(ControlCenter.getDrawingBackGroundColor());
		super.paintComponent(g);
		
		for(EveryGra e : HisGra){
			int ersx = e.sx>e.ex?e.ex:e.sx;
			int ersy = e.sy>e.ey?e.ey:e.sy;
			int erex = e.sx>e.ex?e.sx:e.ex;
			int erey = e.sy>e.ey?e.sy:e.ey;
			g.setColor(e.GraColor);
			g.setFont(e.TextFont);
			switch(e.GraType){
			case 0:
				if(e.isFilled){
					g.fillOval(ersx, ersy, erex-ersx, erex-ersx);
				}else{
					g.drawOval(ersx, ersy, erex-ersx, erex-ersx);
				}
				break;
			case 1:
				if(e.isFilled){
					g.fillOval(ersx, ersy, erex-ersx, erey-ersy);
				}else{
					g.drawOval(ersx, ersy, erex-ersx, erey-ersy);
				}
				break;
			case 2:
				g.drawLine(e.sx, e.sy, e.ex, e.ey);
				break;
			case 3:
				if(e.isFilled){
					g.fillRect(ersx, ersy, erex-ersx, erey-ersy);
				}else{
					g.drawRect(ersx, ersy, erex-ersx, erey-ersy);
				}
				break;
			case 4:
				g.drawString(e.GraText, ersx, ersy);
			}
		}
		
		g.setColor(ControlCenter.getShapeColor());
		g.setFont(new Font("TimesNewRoman", Font.BOLD, ControlCenter.getTextSize()));
		int rsx = sx>ex?ex:sx;
		int rsy = sy>ey?ey:sy;
		int rex = sx>ex?sx:ex;
		int rey = sy>ey?sy:ey;
		
		switch(ControlCenter.getPainterShape()){
		case 0:
			if(ControlCenter.isFillShape()){
				g.fillOval(rsx, rsy, rex-rsx, rex-rsx);
			}else{
				g.drawOval(rsx, rsy, rex-rsx, rex-rsx);
			}
			break;
		case 1:
			if(ControlCenter.isFillShape()){
				g.fillOval(rsx, rsy, rex-rsx, rey-rsy);
			}else{
				g.drawOval(rsx, rsy, rex-rsx, rey-rsy);
			}
			break;
		case 2:
			g.drawLine(sx, sy, ex, ey);
			break;
		case 3:
			if(ControlCenter.isFillShape()){
				g.fillRect(rsx, rsy, rex-rsx, rey-rsy);
			}else{
				g.drawRect(rsx, rsy, rex-rsx, rey-rsy);
			}
			break;
		case 4:
			g.drawString(ControlCenter.getDrawingText(), rsx, rsy);
		}
		
	}
}


