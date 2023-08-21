package Course_Project;

import javax.swing.JOptionPane;

public class HistoryControler {
	int Winner = 0;
	public void TurnToNextRound() {
		// TODO Auto-generated method stub
		Vars.historymodel.ClearChess();
		Vars.historychesspanel.repaint();
		Vars.historypanel.TurnNextRound();
	}

	public void TurnToLastRound() {
		// TODO Auto-generated method stub
		Vars.historymodel.ClearChess();
		Vars.historychesspanel.repaint();
		Vars.historypanel.TurnLastRound();
	}

	public void TurnToNextStep() {
		// TODO Auto-generated method stub
		Vars.historypanel.TurnNextStep();
	}

	public void TurnToLastStep() {
		// TODO Auto-generated method stub
		Vars.historypanel.TurnLastStep();
	}

	public void PutChess(int row, int col, int color) {
		// TODO Auto-generated method stub
		Vars.historymodel.putChess(row, col, color);
		Vars.historypanel.repaint();
		Winner = Vars.historymodel.WhoWin();
		if(Winner == GameModel.BLACK){
			JOptionPane.showMessageDialog(null, "黑子获胜");
		}
		else if(Winner == GameModel.WHITE){
			JOptionPane.showMessageDialog(null, "白子获胜");
		}
	}

	public void RetractChess(int row, int col, int color) {
		// TODO Auto-generated method stub
		Vars.historymodel.RetrackChess(row, col, color);
		Vars.historypanel.repaint();
		Winner = 0;
	}
	
}
