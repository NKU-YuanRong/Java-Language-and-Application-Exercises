package Course_Project;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Audience {
	Socket s;
	PrintWriter out;
	BufferedReader in;
	public Audience() {
		// TODO Auto-generated constructor stub
		s = null;
		out = null;
		in = null;
	}
	public Audience(Socket so, PrintWriter pw, BufferedReader bu) {
		// TODO Auto-generated constructor stub
		s = so;
		out = pw;
		in = bu;
	}
}
