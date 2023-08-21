package Chapter17_网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 8088);
		final BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		new Thread(){
			public void run(){
				String line = "";
				while(true){
					try {
						line = in.readLine();
						if(line == null){
							break;
						}
						System.out.println(line);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("连接已断开");
			}
		}.start();
		Scanner sc = new Scanner(System.in);
		while(true){
			out.println(sc.nextLine());
		}
	}
}
