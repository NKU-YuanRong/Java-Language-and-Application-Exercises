package Course_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HistoryPanel extends JPanel{
	public LinkedList<ArrayList<ChessPoint>> lal;
	int CurrentRound = -1;
	int CurrentStep = -1;
	HistoryNorthPanel historynorthpane;
	HistorySouthPanel historysouthpane = new HistorySouthPanel();
	public HistoryPanel() {
		//super();
		lal = (LinkedList<ArrayList<ChessPoint>>)ReadAndWriteHistory.read();
		if(lal == null){
			lal = new LinkedList<ArrayList<ChessPoint>>();
		}
		CurrentRound = lal.size()-1;
		historynorthpane = new HistoryNorthPanel(CurrentRound);
		setLayout(new BorderLayout());
		add(historynorthpane,BorderLayout.NORTH);
		add(Vars.historychesspanel,BorderLayout.CENTER);
		add(historysouthpane,BorderLayout.SOUTH);
	}
	public void Add(){
		lal.add(new ArrayList<ChessPoint>());
	}
	public ArrayList<ChessPoint> Gettop(){
		if(lal.size()==0){
			return null;
		}
		else{
			return lal.get(lal.size() - 1);
		}
	}
	public void SaveHistory(){
		ReadAndWriteHistory.write(lal);
	}
	public void TurnNextRound() {
		// TODO Auto-generated method stub
		if(CurrentRound >= lal.size()-1){
			JOptionPane.showMessageDialog(null, "已是最后一局");
		}else{
//			Vars.historymodel.ClearChess();
			CurrentRound++;
			CurrentStep = -1;
			historysouthpane.setPrePared();
			historynorthpane.TurnToPage(CurrentRound);
		}
	}
	public void TurnLastRound() {
		// TODO Auto-generated method stub
		if(CurrentRound<=0){
			JOptionPane.showMessageDialog(null, "已是第一局");
		}
		else{
//			Vars.historymodel.ClearChess();
			CurrentRound--;
			CurrentStep = -1;
			historysouthpane.setPrePared();
			historynorthpane.TurnToPage(CurrentRound);
		}
	}
	
	public void TurnNextStep() {
		// TODO Auto-generated method stub
		if(CurrentStep >= lal.get(CurrentRound).size()-1){
			JOptionPane.showMessageDialog(null, "棋局已结束");
		}
		else{
			CurrentStep++;
			historysouthpane.SetNowStep(CurrentStep);
			int trow = lal.get(CurrentRound).get(CurrentStep).row;
			int tcol = lal.get(CurrentRound).get(CurrentStep).col;
			int tcolor = lal.get(CurrentRound).get(CurrentStep).color;
			//System.out.println(trow + " " + tcol + " " + tcolor);
			Vars.historycontroler.PutChess(trow, tcol, tcolor);
			
		}
	}
	
	public void TurnLastStep() {
		// TODO Auto-generated method stub
		if(CurrentStep < 0){
			JOptionPane.showMessageDialog(null, "已是第一步棋！");
		}
		else{
			Vars.historycontroler.RetractChess(lal.get(CurrentRound).get(CurrentStep).row,
					lal.get(CurrentRound).get(CurrentStep).col,
					lal.get(CurrentRound).get(CurrentStep).color);
			CurrentStep--;
			historysouthpane.SetNowStep(CurrentStep);
		}
	}
	
}
