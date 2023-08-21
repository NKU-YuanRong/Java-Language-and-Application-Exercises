package Course_Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class NetAssistant {
	public static int PORT;
	private ServerSocket ss = null;
	private Socket s = null;
	protected PrintWriter out;
	protected BufferedReader in;
	ArrayList<Audience> audiences = new ArrayList<Audience>();
	
	public void listen(int p){
		PORT = p;
		new Thread(){
			public void run(){
				try {
					ss = new ServerSocket(PORT);
					s = ss.accept();
					out = new PrintWriter(s.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					Vars.control.StartGame();
					//GetNewWatcher();
					startReadThread();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
//	private void GetNewWatcher() throws IOException {
//		new Thread(){
//			public void run(){
//				try {
//					final Socket ts = ss.accept();
//					GetNewWatcher();
//					PrintWriter tout = new PrintWriter(ts.getOutputStream(), true);
//					final BufferedReader tin = new BufferedReader(new InputStreamReader(ts.getInputStream()));
//					StartWatcherReanThread(ts, tin);
//					Vars.assistent.audiences.add(new Audience(ts, tout, tin));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//
//			private void StartWatcherReanThread(final Socket ts, final BufferedReader tin) {
//				new Thread(){
//					public void run() {
//						while(ts != null){
//							try {
//								String line = tin.readLine();
//								if(line==null){
//									//Vars.control.NetAdmitDefeat();
//									//Vars.control.WatchingEnd(GameModel.SPACE);
//									return;
//								}
////								parseMessage(line);
//								parseWatcherMessage(line);
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				}.start();
//			}
//			
//			
//		}.start();
//	}
	
	public void connect(final String ip, final int p){
		PORT = p;
		new Thread(){
			public void run(){
				try {
					s = new Socket(ip, PORT);
					out = new PrintWriter(s.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					Vars.control.StartGame();
					startReadThread();
				} catch (IOException e) {
//					e.printStackTrace();
					Vars.connectionpanel.Clear();
				}
			}
		}.start();
	}
	
//	public void watch(final String ip, final int p){
//		PORT = p;
//		new Thread(){
//			public void run(){
//				try {
//					s = new Socket(ip, PORT);
//					out = new PrintWriter(s.getOutputStream(), true);
//					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//					//Vars.control.StartWatching();
//					startReadThread();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}.start();
//
//	}//观战者连接主机
	
	protected void startReadThread() {
		new Thread(){
			public void run() {
				while(s != null){
					try {
						String line = in.readLine();
						if(line==null){
							Vars.control.NetAdmitDefeat();
							return;
						}
						parseMessage(line);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	protected void parseMessage(String line) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		if(line.startsWith("PutChess:")){
			parsePutChess(line);
		}
		else if(line.startsWith("Chat:")){
			parseChat(line);
		}
		else if(line.startsWith("DrawAsk")){
			Vars.control.NetDrawRoundAsk();
		}
		else if(line.startsWith("Retract")){
			Vars.control.NetRetractRequest();
		}
		else if(line.startsWith("Defeat")){
			Vars.control.NetAdmitDefeat();
		}
		else if(line.startsWith("ServerQuit")){
			out.println("ClientQuit");
			ClientQuit();
		}
		else if(line.startsWith("ClientQuit")){
			ServerQuit();
		}
		else if(line.startsWith("AgreeDraw")){
			Vars.control.DrawRound();
		}
		else if(line.startsWith("RefuseDraw")){
			Vars.control.NetRefuseDraw();
		}
		else if(line.startsWith("RefuseRetrack")){
			Vars.control.NetRefuseRetrack();
		}
		else if(line.startsWith("AgreeRetrack")){
			Vars.control.NetAgreeRetrack();
		}
		else if(line.startsWith("OverTime")){
			Vars.control.NetOverTime();
		}
		else if(line.startsWith("Copy")){
			Vars.chatpanel.addChatMessage("对方已收到");
		}
	}
//	
//	private void parseWatcherMessage(String line) throws IOException {
//		if(line.startsWith("PutChess:")){
//			parseWatcherPutChess(line);
//		}
//		else if(line.startsWith("AgreeRetrack")){
//			parseWatcherRetrack(line);
//		}
//	}

//
//	private void parseWatcherRetrack(String line) {
//		// TODO Auto-generated method stub
//		line = line.substring(12);
//		int color = Integer.parseInt(line);
//		Vars.control.WatcherRetrack(color);
//	}
//
//	private void parseWatcherPutChess(String line) throws IOException {
//		// TODO Auto-generated method stub
//		line = line.substring(9);
//		String[] Position = line.split(",");
//		int row = Integer.parseInt(Position[0]);
//		int col = Integer.parseInt(Position[1]);
//		int color = Integer.parseInt(Position[2]);
//		Vars.control.WatcherNetPutChess(row,col,color);
//	}

	private void ServerQuit() throws IOException {
		// TODO Auto-generated method stub
		in.close();
		out.close();
		s.close();
		s = null;
		ss.close();
		ss = null;
	}

	private void parseChat(String line) {
		line = line.substring(5);
		Vars.control.NetGetMessage(line);
		out.println("Copy");
	}

	private void parsePutChess(String line) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		line = line.substring(9);
		String[] Position = line.split(",");
		int row = Integer.parseInt(Position[0]);
		int col = Integer.parseInt(Position[1]);
		Vars.control.NetPutChess(row,col);
	}

	public void sendChess(int row, int col) {
		out.println("PutChess:" + row + "," + col);
//		for(int i = 0; i < Vars.assistent.audiences.size(); i++){
//			Vars.assistent.audiences.get(i).out.println("PutChess:" + row + "," + col+ "," + Vars.control.localColor);
//		}
	}
	public void OverTime() {
		out.println("OverTime");
	}

	public void sendMessage(String msg) {
		// TODO Auto-generated method stub
		out.println("Chat:" + msg);
	}

	public void DrawRoundAsk(){
		out.println("DrawAsk");
	}//发出和棋请求

	public void RetractAsk() {
		out.println("Retract");
	}//发出悔棋请求

	public void AdmitDefeat() {
		// TODO Auto-generated method stub
		out.println("Defeat");
	}

	public void ServerQuitSign() throws IOException {
		out.println("ServerQuit");
	}

	public void ClientQuit() throws IOException {
		// TODO Auto-generated method stub
		in.close();
		out.close();
		s.close();
		s = null;
		ss.close();
		ss = null;
	}

	public void AgreeDraw() {
		out.println("AgreeDraw");
	}

	public void RefuseDraw() {
		// TODO Auto-generated method stub
		out.println("RefuseDraw");
	}

	public void RefuseRetrack() {
		// TODO Auto-generated method stub
		out.println("RefuseRetrack");
	}//拒绝对方的悔棋请求

	public void AgreeRetrack() {
		// TODO Auto-generated method stub
		out.println("AgreeRetrack");
		for(int i = 0; i < Vars.assistent.audiences.size(); i++){
			Vars.assistent.audiences.get(i).out.println("AgreeRetrack" + Vars.control.otherColor);
		}
	}//同意对方的悔棋请求
}
