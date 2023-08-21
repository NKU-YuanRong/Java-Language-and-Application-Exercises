package Course_Project;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Vars {
	public static GameModel model = new GameModel();
	public static ChessPanel chesspanel = new ChessPanel();
	public static HistoryChessPanel historychesspanel = new HistoryChessPanel();
	//public static ChessPanel watcherchesspanel = new ChessPanel();
	public static Controller control = new Controller();
	public static NetAssistant assistent = new NetAssistant();
	//public static NorthPanel northpanel = new NorthPanel();
	public static ChatPanel chatpanel = new ChatPanel();
	//public static ChatPanel watcherchatpanel = new ChatPanel();
	public static SouthPanel southpanel = new SouthPanel();
	public static NorthPanel northpanel = new NorthPanel();
	public static MainPanel mainpanel = new MainPanel();
	public static PanelSwitcher switcher = new PanelSwitcher();
	public static NetConnectionPanel connectionpanel = new NetConnectionPanel();
	public static GameFrame gameframe;
	public static NetGamePanel netgamepanel = new NetGamePanel();
	public static WatcherPanel watcherpanel = new WatcherPanel();
	public static HistoryPanel historypanel = new HistoryPanel();
//	public static HistoryNorthPanel historynorthpanel = new HistoryNorthPanel();
	public static HistoryControler historycontroler = new HistoryControler();
//	public static HistorySouthPanel historysouthpanel = new HistorySouthPanel();
	public static HistoryModel historymodel = new HistoryModel();
	public static ChessingSound chessingsound;
	//public static HistoryChessPanel historychesspanel = new HistoryChessPanel();
	//public static WelcomeFrame welcomeframe = new WelcomeFrame();
	//public static NetConnectFrame netconnectframe= new NetConnectFrame();
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		//chessingsound = new ChessingSound();
		gameframe = new GameFrame();
		chessingsound = new ChessingSound();
		chessingsound.Sound();
	}
}
