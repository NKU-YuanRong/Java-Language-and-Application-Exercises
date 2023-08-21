package Chapter17_网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestLink {
	public static void main(String[] args) throws IOException {
		final ServerSocket ss = new ServerSocket(8088);
		final Socket s = ss.accept();
		final PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		final BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		Scanner sysin = new Scanner(System.in);
		new Thread(){
			public void run(){
				while(true){
					try {
						String line = in.readLine();
						if(line == null){
							break;
						}
						System.out.println(line);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
				System.out.println("连接结束");
				try {
					in.close();
					out.close();
					s.close();
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
		while(true){
			out.println(sysin.nextLine());
		}
	}
}
