package Chapter15;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testFilterInputStream {
	public static void main(String[] args) throws IOException {
		File file1 = new File("D:/FFOutput/copyText.txt");
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
//		int c;
//		while((c = bis.read()) != -1){
//			System.out.print((char)c);
//		}
//		bis.close();
		BufferedReader bf = new BufferedReader(new FileReader(file1));
		int c;
		while((c = bf.read()) != -1){
			System.out.print((char)c);
		}
		bf.close();
	}
}
