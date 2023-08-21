package Chapter17_ÍøÂç±à³Ì;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8030);
		System.out.println("Begin Listen");
		Socket s = ss.accept();
		System.out.println("Receive Client: " + s);
		final BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		new Thread(){
			public void run(){
				while(true){
					try {
						String line = in.readLine();
						System.out.println(line);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = key.readLine();
			out.println(line);
		}
		
//		s.close();
//		ss.close();
//		in.close();
//		out.close();
	}
}
