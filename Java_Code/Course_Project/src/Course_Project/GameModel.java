package Course_Project;

import java.util.ArrayList;

public class GameModel {
	public static final int BLACK = 1;
	public static final int WHITE = -1;
	public static final int SPACE = 0;
	public static final int WIDTH = 19;
	protected int Winner = 0;
	//private ArrayList<ChessPoint> history = new ArrayList<ChessPoint>();
	
	protected int[][] ChessBoard = new int[WIDTH][WIDTH];
	
	public boolean putChess(int row,int col,int color){
		if(InputIsLegal(row, col) && ChessBoard[row][col] == GameModel.SPACE){
			ChessBoard[row][col]=color;
			Vars.historypanel.Gettop().add(new ChessPoint(row, col, color));
			Winner = WinOrNot(row, col, color);
			return true;
		}
		return false;
	}
	
	protected boolean InputIsLegal(int row, int col) {
		if(row<0 || row>=WIDTH){
			return false;
		}
		if(col<0 || col>=WIDTH){
			return false;
		}
		return true;
	}
	
	protected int WinOrNot(int row, int col, int color){
		int count = 0;//count用于记录连子数量，若达到5则游戏结束
		
		for(int i = col - 4; i < col + 5; i++){
			if(i < 0 || i >= WIDTH){
				continue;
			}
			if(ChessBoard[row][i] == color){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return color;
			}
		}
		count = 0;
		//横向判断
		
		for(int i = row - 4; i < row + 5; i++){
			if(i < 0 || i > WIDTH - 1){
				continue;
			}
			if(ChessBoard[i][col] == color){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return color;
			}
		}
		count = 0;
		//纵向判断
		
		for(int i = -4; i < 5; i++){
			if((col + i < 0 || col + i > WIDTH - 1) || (row + i < 0 || row + i > WIDTH - 1)){
				continue;
			}
			if(ChessBoard[row + i][col + i] == color){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return color;
			}
		}
		count = 0;
		//左上到右下判断
		
		for(int i = -4; i < 5; i++){
			if(col - i < 0 || col - i >= WIDTH || row + i < 0 || row + i >= WIDTH){
				continue;
			}
			if(ChessBoard[row + i][col - i] == color){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return color;
			}
		}//右上到左下判断
		
		return SPACE;
	}
	
	public int getChess(int row, int col){
		if(InputIsLegal(row, col)){
			return ChessBoard[row][col];
		}
		return 0;
	}
	
	public int WhoWin(){
		return Winner;
	}
	
	public int getChessCount(){
		return Vars.historypanel.Gettop().size();
	}
	
	public ChessPoint getChessPoint(int index){
		return Vars.historypanel.Gettop().get(index);
	}

	public void ClearChess() {
		// TODO Auto-generated method stub
		for(int i = 0;i < WIDTH; i++){
			for(int j = 0; j < WIDTH; j++){
				ChessBoard[i][j] = 0;
				Vars.chesspanel.repaint();
			}
		}
	}
	
	public void Retrack(int RetrackColor) {
		int i = Vars.historypanel.Gettop().size() - 1;
		if(i == -1){
			return;
		}
		ChessPoint temp = Vars.historypanel.Gettop().remove(i);
		if(temp.color != RetrackColor){
			Retrack(RetrackColor);
		}
		ChessBoard[temp.row][temp.col] = SPACE;
	}
	
	public void SaveHistory() {
		// TODO Auto-generated method stub
		new Thread(){
			public void run(){
				//ReadAndWriteHistory.write(history);
				Vars.historypanel.SaveHistory();
				//history.removeAll(null);
			}
		}.start();
	}
}
