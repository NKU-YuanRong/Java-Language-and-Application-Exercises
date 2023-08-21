package Course_Project;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Controller {
	private boolean OpenDoor = false;
	private boolean OpenDoorStateWhenRetrack = false;
	public int localColor;
	public int otherColor;
//	private boolean OtherQuit = false;
	public void LocalPutChess(int row,int col) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		if(!OpenDoor){
			return;
		}
		boolean success = Vars.model.putChess(row, col, localColor);
		if(success){
			Vars.assistent.sendChess(row,col);
			//Vars.chessingsound.Sound();
			//new ChessingSound();
			Vars.northpanel.StopTiming();
			OpenDoor = false;
			Vars.chesspanel.repaint();
			int winner = Vars.model.WhoWin();
			if(winner==GameModel.BLACK){
				JOptionPane.showMessageDialog(null, "黑子胜！");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
			else if(winner==GameModel.WHITE){
				JOptionPane.showMessageDialog(null, "白子胜！");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
		}
	}
	
	public void GiveUpChessing() {
		// TODO Auto-generated method stub
		
		Vars.assistent.OverTime();
		OpenDoor = false;
		Vars.chatpanel.addChatMessage("【你已超时，丧失本轮棋权，请积极游戏】");
	}
	
	public void NetPutChess(int row, int col) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		boolean success = Vars.model.putChess(row, col, otherColor);
		if(success){
			Vars.chesspanel.repaint();
			//Vars.chessingsound.Sound();
			//new ChessingSound();
			int winner = Vars.model.WhoWin();
			if(winner==GameModel.BLACK){
				JOptionPane.showMessageDialog(null, "黑子胜！");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
			else if(winner==GameModel.WHITE){
				JOptionPane.showMessageDialog(null, "白子胜！");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
			else{
				OpenDoor = true;
			Vars.northpanel.BeginTiming();
			}
		}
	}
	
	public void NetOverTime() {
		// TODO Auto-generated method stub
		OpenDoor = true;
		Vars.northpanel.BeginTiming();
	}
	
//	public void WatcherNetPutChess(int row, int col, int color) throws IOException {
//		// TODO Auto-generated method stub
//		boolean success = Vars.model.putChess(row, col, color);
//		if(success){
////			Vars.watcherchesspanel.repaint();
//			int winner = Vars.model.WhoWin();
//			if(winner==GameModel.BLACK){
//				JOptionPane.showMessageDialog(null, "黑子胜！");
//				WatchingEnd(winner);
//			}
//			else if(winner==GameModel.WHITE){
//				JOptionPane.showMessageDialog(null, "白子胜！");
//				WatchingEnd(winner);
//			}
//			OpenDoor = true;
//		}
//	}
	
	private void EndGame(int winner) throws IOException {
		String WinMsg;
		if(winner == localColor){
			WinMsg = "你赢了!";
		}
		else if(winner == otherColor){
			WinMsg = "别灰心，下次再接再厉";
		}
		else{
			WinMsg = "以和为贵";
		}
		Vars.model.SaveHistory();
		String options[] = {"回到主界面", "再来一局"};
		int choice = 1;
		choice = JOptionPane.showOptionDialog(null, "游戏结束", 
				WinMsg, JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, "退出房间");
		switch(choice){
		case 0://选择回到主界面
			Vars.chatpanel.Clear();
			QuitRoomMain();
			Vars.model.ClearChess();
			break;
		case 1://选择再来一局
			Vars.chatpanel.Clear();
			QuitRoom();
			Vars.model.ClearChess();
			break;
		}
	}//结束游戏
	
	private void QuitRoomMain() throws IOException {
		// TODO Auto-generated method stub
		if(localColor == GameModel.BLACK){
			Vars.assistent.ServerQuitSign();
		}
		Vars.switcher.BackToMain();
	}
	
	private void QuitRoom() throws IOException {
		//Vars.assistent.QuitSign();
		if(localColor == GameModel.BLACK){
			Vars.assistent.ServerQuitSign();
		}
		Vars.switcher.EnterNetMode();
	}

	public void BeginListen(int i) {
		Vars.assistent.listen(i);
		Vars.chatpanel.changeInputAndSendAvailable();
		Vars.southpanel.changeButtonAvailable();
		OpenDoor = true;
		Vars.control.localColor = GameModel.BLACK;
		Vars.control.otherColor = GameModel.WHITE;
	}
	
	public void BeginConnect(String ip, int p) {
		Vars.assistent.connect(ip, p);
		Vars.chatpanel.changeInputAndSendAvailable();
		Vars.southpanel.changeButtonAvailable();
		OpenDoor = false;
		Vars.control.localColor = GameModel.WHITE;
		Vars.control.otherColor = GameModel.BLACK;
	}
	
//	public void BeginWatching(String ip, int p) {
//		Vars.assistent.watch(ip, p);
//		Vars.chatpanel.changeInputAndSendAvailable();
//		Vars.control.localColor = GameModel.SPACE;
//		Vars.control.otherColor = GameModel.SPACE;
//	}//加入观战
	
	public void sendChatMessage(String msg) {
		Vars.assistent.sendMessage(msg);
		Vars.chatpanel.addChatMessage("我: " + msg);
	}
	
	public void NetGetMessage(String msg) {
		Vars.chatpanel.addChatMessage("对手: " + msg);
	}//收到网络信息
	
	
	public void DrawRoundRequest() {
		Vars.chatpanel.addChatMessage("【你发起了和棋请求，等待对方同意】");
		Vars.assistent.DrawRoundAsk();
	}//自己发出和棋请求
	public void NetDrawRoundAsk() throws IOException {
		Vars.chatpanel.addChatMessage("【对方发起了和棋请求】");
		int rst = JOptionPane.NO_OPTION;
		rst = JOptionPane.showConfirmDialog(null, "对方发出了和棋申请，是否同意？","和棋",JOptionPane.YES_NO_OPTION);
		if(rst == JOptionPane.YES_OPTION){
			Vars.chatpanel.addChatMessage("【你同意了对方的和棋请求，游戏结束】");
			Vars.assistent.AgreeDraw();
			EndGame(GameModel.SPACE);
		}
		else if(rst == JOptionPane.NO_OPTION){
			Vars.chatpanel.addChatMessage("【你拒绝了对方的和棋请求，游戏继续！】");
			Vars.assistent.RefuseDraw();
		}
	}//对方发出和棋请求
	
	public void RetractRequest() {
		Vars.chatpanel.addChatMessage("【你发起了悔棋请求，等待对方同意】");
		OpenDoorStateWhenRetrack = OpenDoor;
		OpenDoor = false;
		Vars.assistent.RetractAsk();
		if(Vars.northpanel.IsTiming()){
			Vars.northpanel.StopTiming();
		}
	}//自己发出悔棋请求
	
	public void NetRetractRequest() {
		Vars.chatpanel.addChatMessage("【对方发起了悔棋请求】");
		if(Vars.northpanel.IsTiming()){
			Vars.northpanel.StopTiming();
		}
		//Vars.northpanel.StopTiming();
		int rst = JOptionPane.NO_OPTION;
		rst = JOptionPane.showConfirmDialog(null, "对方发出悔棋申请，是否同意？","悔棋",JOptionPane.YES_NO_OPTION);
		if(rst == JOptionPane.YES_OPTION){
			Vars.chatpanel.addChatMessage("【你同意了对方的悔棋申请！】");
			OpenDoor = false;
			Vars.model.Retrack(otherColor);
			Vars.chesspanel.repaint();
			Vars.assistent.AgreeRetrack();
		}
		else if(rst == JOptionPane.NO_OPTION){
			Vars.chatpanel.addChatMessage("【你拒绝了对方的悔棋申请！】");
			Vars.assistent.RefuseRetrack();
		}
	}//对方发出悔棋请求
	
	public void AdmitDefeatRequest() throws IOException {
		Vars.chatpanel.addChatMessage("【你认输了，对方获得胜利！】");
		Vars.assistent.AdmitDefeat();
		EndGame(otherColor);
	}//自己认输
	public void NetAdmitDefeat() throws IOException {
		Vars.chatpanel.addChatMessage("【对方认输，你获得了游戏胜利！】");
		EndGame(localColor);
	}//对方认输

	public void StartGame() {
		Vars.chatpanel.addChatMessage("【双方已进入房间，游戏开始】");
		if(localColor == GameModel.BLACK){
			Vars.chatpanel.addChatMessage("【本局你为黑棋，先手下棋】");
			Vars.northpanel.BeginTiming();
		}
		else{
			Vars.chatpanel.addChatMessage("【本局你为白棋，后手下棋】");
		}
		Vars.historypanel.Add();
		Vars.switcher.ToGameWindow();
	}
	
//	public void StartWatching() {
//		Vars.chatpanel.addChatMessage("【已进入观战】");
//		Vars.switcher.ToWatchWindow();
//	}

	public void DrawRound() throws IOException {
		// TODO Auto-generated method stub
		EndGame(GameModel.SPACE);
	}

	public void NetRefuseDraw() {
		// TODO Auto-generated method stub
		Vars.chatpanel.addChatMessage("【对方拒绝了和棋申请，游戏继续！】");
	}

	public void NetRefuseRetrack() {
		// TODO Auto-generated method stub
		Vars.chatpanel.addChatMessage("【对方拒绝了悔棋申请！】");
		OpenDoor = OpenDoorStateWhenRetrack;
	}

	public void NetAgreeRetrack() {
		// TODO Auto-generated method stub
		Vars.chatpanel.addChatMessage("【对方同意了悔棋申请，悔棋成功！】");
		Vars.model.Retrack(localColor);
		Vars.chesspanel.repaint();
		OpenDoor = true;
		Vars.northpanel.BeginTiming();
	}
//
//	public void WatchingEnd(int winner) throws IOException {
//		// TODO Auto-generated method stub
//		String WinMsg;
//		if(winner == GameModel.BLACK){
//			WinMsg = "黑方胜利";
//		}
//		else if(winner == GameModel.WHITE){
//			WinMsg = "白方胜利";
//		}
//		else{
//			WinMsg = "以和为贵";
//		}
//		Vars.chatpanel.addChatMessage("【观战结束】");
//		String options[] = {"回到主界面", "继续观战"};
//		int choice = JOptionPane.showOptionDialog(null, "游戏结束", WinMsg, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "退出房间");
//		switch(choice){
//		case 0://选择回到主界面
//			QuitRoomMain();
//			Vars.model.ClearChess();
//			break;
//		case 1://选择再来一局
//			QuitRoom();
//			Vars.model.ClearChess();
//			break;
//		}
//	}
//	
//	public void WatcherRetrack(int color) {
//		// TODO Auto-generated method stub
//		Vars.chatpanel.addChatMessage("【对方同意了悔棋申请，悔棋成功！】");
//		Vars.model.Retrack(color);
//		Vars.chesspanel.repaint();
//	}




}
