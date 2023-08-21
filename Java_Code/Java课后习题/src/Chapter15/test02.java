package Chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class test02 {
	public static void main(String[] args) throws IOException {
		File file1 = new File("D:/FFOutput/newText.txt");
		File file2 = new File("D:/FFOutput/copyText.txt");
//		FileInputStream fis = new FileInputStream(file1);
//		FileOutputStream fos = new FileOutputStream(file2);
//		int mid = 0;
//		while((mid = fis.read()) != -1){
//			fos.write(mid);
//		}
//		fis.close();
//		fos.close();
		RandomAccessFile raf = new RandomAccessFile(file1, "rw");
		for (int i = 0; i < 10; i++) {
			raf.writeInt(i);
		}
		raf.seek(3);
		int c = raf.readInt();
		System.out.println(c);
	}
}

