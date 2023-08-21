package Chapter15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class test07 {
	public static void main(String[] args) throws IOException {
//		File file1 = new File("D:/FFOutput/newText.txt");
//		File file1 = new File("D:/FFOutput/copyText.txt");
		String path = "";
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		path = keyin.readLine();
		File file1 = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file1));
		String s;
		LinkedList<String> lls = new LinkedList<String>();
		while((s = in.readLine()) != null){
//			s = s.toUpperCase();
			lls.add(s);
		}
//		while(lls.size() != 0){
//			System.out.println(lls.pop());
//		}
		System.out.println("Please input the string you want to find: ");
		String rsc = keyin.readLine();
		while(lls.size() != 0){
			String temp = lls.pop();
			if(temp.indexOf(rsc) >= 0){
				System.out.println(temp);
			}
		}
	}
}
