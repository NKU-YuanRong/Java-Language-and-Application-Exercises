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
				JOptionPane.showMessageDialog(null, "����ʤ��");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
			else if(winner==GameModel.WHITE){
				JOptionPane.showMessageDialog(null, "����ʤ��");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
		}
	}
	
	public void GiveUpChessing() {
		// TODO Auto-generated method stub
		
		Vars.assistent.OverTime();
		OpenDoor = false;
		Vars.chatpanel.addChatMessage("�����ѳ�ʱ��ɥʧ������Ȩ���������Ϸ��");
	}
	
	public void NetPutChess(int row, int col) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		boolean success = Vars.model.putChess(row, col, otherColor);
		if(success){
			Vars.chesspanel.repaint();
			//Vars.chessingsound.Sound();
			//new ChessingSound();
			int winner = Vars.model.WhoWin();
			if(winner==GameModel.BLACK){
				JOptionPane.showMessageDialog(null, "����ʤ��");
				Vars.northpanel.StopTiming();
				EndGame(winner);
			}
			else if(winner==GameModel.WHITE){
				JOptionPane.showMessageDialog(null, "����ʤ��");
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
//				JOptionPane.showMessageDialog(null, "����ʤ��");
//				WatchingEnd(winner);
//			}
//			else if(winner==GameModel.WHITE){
//				JOptionPane.showMessageDialog(null, "����ʤ��");
//				WatchingEnd(winner);
//			}
//			OpenDoor = true;
//		}
//	}
	
	private void EndGame(int winner) throws IOException {
		String WinMsg;
		if(winner == localColor){
			WinMsg = "��Ӯ��!";
		}
		else if(winner == otherColor){
			WinMsg = "����ģ��´��ٽ�����";
		}
		else{
			WinMsg = "�Ժ�Ϊ��";
		}
		Vars.model.SaveHistory();
		String options[] = {"�ص�������", "����һ��"};
		int choice = 1;
		choice = JOptionPane.showOptionDialog(null, "��Ϸ����", 
				WinMsg, JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, "�˳�����");
		switch(choice){
		case 0://ѡ��ص�������
			Vars.chatpanel.Clear();
			QuitRoomMain();
			Vars.model.ClearChess();
			break;
		case 1://ѡ������һ��
			Vars.chatpanel.Clear();
			QuitRoom();
			Vars.model.ClearChess();
			break;
		}
	}//������Ϸ
	
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
//	}//�����ս
	
	public void sendChatMessage(String msg) {
		Vars.assistent.sendMessage(msg);
		Vars.chatpanel.addChatMessage("��: " + msg);
	}
	
	public void NetGetMessage(String msg) {
		Vars.chatpanel.addChatMessage("����: " + msg);
	}//�յ�������Ϣ
	
	
	public void DrawRoundRequest() {
		Vars.chatpanel.addChatMessage("���㷢���˺������󣬵ȴ��Է�ͬ�⡿");
		Vars.assistent.DrawRoundAsk();
	}//�Լ�������������
	public void NetDrawRoundAsk() throws IOException {
		Vars.chatpanel.addChatMessage("���Է������˺�������");
		int rst = JOptionPane.NO_OPTION;
		rst = JOptionPane.showConfirmDialog(null, "�Է������˺������룬�Ƿ�ͬ�⣿","����",JOptionPane.YES_NO_OPTION);
		if(rst == JOptionPane.YES_OPTION){
			Vars.chatpanel.addChatMessage("����ͬ���˶Է��ĺ���������Ϸ������");
			Vars.assistent.AgreeDraw();
			EndGame(GameModel.SPACE);
		}
		else if(rst == JOptionPane.NO_OPTION){
			Vars.chatpanel.addChatMessage("����ܾ��˶Է��ĺ���������Ϸ��������");
			Vars.assistent.RefuseDraw();
		}
	}//�Է�������������
	
	public void RetractRequest() {
		Vars.chatpanel.addChatMessage("���㷢���˻������󣬵ȴ��Է�ͬ�⡿");
		OpenDoorStateWhenRetrack = OpenDoor;
		OpenDoor = false;
		Vars.assistent.RetractAsk();
		if(Vars.northpanel.IsTiming()){
			Vars.northpanel.StopTiming();
		}
	}//�Լ�������������
	
	public void NetRetractRequest() {
		Vars.chatpanel.addChatMessage("���Է������˻�������");
		if(Vars.northpanel.IsTiming()){
			Vars.northpanel.StopTiming();
		}
		//Vars.northpanel.StopTiming();
		int rst = JOptionPane.NO_OPTION;
		rst = JOptionPane.showConfirmDialog(null, "�Է������������룬�Ƿ�ͬ�⣿","����",JOptionPane.YES_NO_OPTION);
		if(rst == JOptionPane.YES_OPTION){
			Vars.chatpanel.addChatMessage("����ͬ���˶Է��Ļ������룡��");
			OpenDoor = false;
			Vars.model.Retrack(otherColor);
			Vars.chesspanel.repaint();
			Vars.assistent.AgreeRetrack();
		}
		else if(rst == JOptionPane.NO_OPTION){
			Vars.chatpanel.addChatMessage("����ܾ��˶Է��Ļ������룡��");
			Vars.assistent.RefuseRetrack();
		}
	}//�Է�������������
	
	public void AdmitDefeatRequest() throws IOException {
		Vars.chatpanel.addChatMessage("���������ˣ��Է����ʤ������");
		Vars.assistent.AdmitDefeat();
		EndGame(otherColor);
	}//�Լ�����
	public void NetAdmitDefeat() throws IOException {
		Vars.chatpanel.addChatMessage("���Է����䣬��������Ϸʤ������");
		EndGame(localColor);
	}//�Է�����

	public void StartGame() {
		Vars.chatpanel.addChatMessage("��˫���ѽ��뷿�䣬��Ϸ��ʼ��");
		if(localColor == GameModel.BLACK){
			Vars.chatpanel.addChatMessage("��������Ϊ���壬�������塿");
			Vars.northpanel.BeginTiming();
		}
		else{
			Vars.chatpanel.addChatMessage("��������Ϊ���壬�������塿");
		}
		Vars.historypanel.Add();
		Vars.switcher.ToGameWindow();
	}
	
//	public void StartWatching() {
//		Vars.chatpanel.addChatMessage("���ѽ����ս��");
//		Vars.switcher.ToWatchWindow();
//	}

	public void DrawRound() throws IOException {
		// TODO Auto-generated method stub
		EndGame(GameModel.SPACE);
	}

	public void NetRefuseDraw() {
		// TODO Auto-generated method stub
		Vars.chatpanel.addChatMessage("���Է��ܾ��˺������룬��Ϸ��������");
	}

	public void NetRefuseRetrack() {
		// TODO Auto-generated method stub
		Vars.chatpanel.addChatMessage("���Է��ܾ��˻������룡��");
		OpenDoor = OpenDoorStateWhenRetrack;
	}

	public void NetAgreeRetrack() {
		// TODO Auto-generated method stub
		Vars.chatpanel.addChatMessage("���Է�ͬ���˻������룬����ɹ�����");
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
//			WinMsg = "�ڷ�ʤ��";
//		}
//		else if(winner == GameModel.WHITE){
//			WinMsg = "�׷�ʤ��";
//		}
//		else{
//			WinMsg = "�Ժ�Ϊ��";
//		}
//		Vars.chatpanel.addChatMessage("����ս������");
//		String options[] = {"�ص�������", "������ս"};
//		int choice = JOptionPane.showOptionDialog(null, "��Ϸ����", WinMsg, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "�˳�����");
//		switch(choice){
//		case 0://ѡ��ص�������
//			QuitRoomMain();
//			Vars.model.ClearChess();
//			break;
//		case 1://ѡ������һ��
//			QuitRoom();
//			Vars.model.ClearChess();
//			break;
//		}
//	}
//	
//	public void WatcherRetrack(int color) {
//		// TODO Auto-generated method stub
//		Vars.chatpanel.addChatMessage("���Է�ͬ���˻������룬����ɹ�����");
//		Vars.model.Retrack(color);
//		Vars.chesspanel.repaint();
//	}




}
