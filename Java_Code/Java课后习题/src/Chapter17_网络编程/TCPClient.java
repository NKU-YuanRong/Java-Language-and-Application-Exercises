package Chapter17_ÍøÂç±à³Ì;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 8030);
		final BufferedReader In = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter Out = new PrintWriter(s.getOutputStream(), true);
		
		new Thread(){
			public void run(){
				while(true){
					try {
						String line = In.readLine();
						System.out.println(line);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = key.readLine();
			Out.println(line);
		}
		
//		s.close();
//		in.close();
//		out.close();
	}
}
