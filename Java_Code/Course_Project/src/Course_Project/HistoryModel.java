package Course_Project;

public class HistoryModel extends GameModel{
	public boolean putChess(int row,int col,int color){
		ChessBoard[row][col]=color;
		Winner = WinOrNot(row, col, color);
		return true;
	}
	public void RetrackChess(int row, int col, int color) {
		// TODO Auto-generated method stub
		ChessBoard[row][col] = GameModel.SPACE;
		Winner = GameModel.SPACE;
	}
}
