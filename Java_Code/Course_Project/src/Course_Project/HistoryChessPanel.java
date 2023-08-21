package Course_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HistoryChessPanel extends JPanel{
	int sx=30,sy=30,unit=50,gap=30,edge = 3*unit/4;
	ImageIcon BG = new ImageIcon("BackGroundPic2.png");
	Image BackGround = BG.getImage();
	
	public HistoryChessPanel() {
		super();
		addMouseEventListener();
		addSizeListener();
	}
	private void addSizeListener() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				int wid = getWidth();
				int hei = getHeight();
				int min = wid<hei?wid:hei; 
				unit = (min-gap*2)/(GameModel.WIDTH-1);
				sx = (wid-unit*(GameModel.WIDTH-1))/2;
				sy = (hei-unit*(GameModel.WIDTH-1))/2;
				edge = 3*unit/4;
				repaint();
			}
		});
	}
	private void addMouseEventListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				int row = (e.getY() - sy + unit/2)/unit;
				int col = (e.getX() - sx + unit/2)/unit;
				try {
					Vars.control.LocalPutChess(row,col);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawBackGroundImage(g);
		drawChessPanel(g);
		drawChess(g);
	}
	private void drawChess(Graphics g) {
		// TODO Auto-generated method stub
		for (int row = 0; row < GameModel.WIDTH; row++) {
			for (int col = 0; col < GameModel.WIDTH; col++) {
				int color = Vars.historymodel.getChess(row, col);
				if(color == GameModel.SPACE){
					continue;
				}
				if(color == GameModel.BLACK){
					g.setColor(Color.black);
					g.fillOval(sx+col*unit-unit/2, sy+row*unit-unit/2, unit, unit);
					g.setColor(Color.white);
					g.fillOval(sx+col*unit-unit/2+unit/5, sy+row*unit-unit/2+unit/5, unit/6, unit/6);
				}
				else{
//					g.setColor(Color.white);
					g.setColor(new Color(240,240,240));
					g.fillOval(sx+col*unit-unit/2, sy+row*unit-unit/2, unit, unit);
					g.setColor(Color.white);
					g.fillOval(sx+col*unit-unit/2+unit/5, sy+row*unit-unit/2+unit/5, unit/6, unit/6);
				}
				
			}
		}
	}
	private void drawChessPanel(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		for(int i = 0; i < GameModel.WIDTH; i++){
			g.drawLine(sx, sy+unit*i, sx+unit*(GameModel.WIDTH-1), sy+unit*i);
			g.drawLine(sx+unit*i, sy, sx+unit*i, sy+unit*(GameModel.WIDTH-1));
		}
		g.drawLine(sx-edge, sy-edge, sx+unit*(GameModel.WIDTH-1)+edge, sy-edge);
		g.drawLine(sx-edge, sy-edge, sx+-edge, sy+unit*(GameModel.WIDTH-1)+edge);
		g.drawLine(sx-edge, sy+unit*(GameModel.WIDTH-1)+edge, sx+unit*(GameModel.WIDTH-1)+edge, sy+unit*(GameModel.WIDTH-1)+edge);
		g.drawLine(sx+unit*(GameModel.WIDTH-1)+edge, sy-edge, sx+unit*(GameModel.WIDTH-1)+edge, sy+unit*(GameModel.WIDTH-1)+edge);
	}
	private void drawBackGroundImage(Graphics g) {
		int wid = getWidth();
		int hei = getHeight();
		int max = wid>hei?wid:hei;
//		g.drawImage(BackGround, 0, 0, max, max, null);
		g.drawImage(BackGround, sx-edge, sy-edge, unit*(GameModel.WIDTH-1)+2*edge, unit*(GameModel.WIDTH-1)+2*edge, null);
	}
}
