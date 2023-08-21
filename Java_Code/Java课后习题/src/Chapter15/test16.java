package Chapter15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class test16 {
	static String file = "D:/FFOutput/1510Text.txt";
	  static void display() throws IOException {
	    RandomAccessFile rf = new RandomAccessFile(file, "r");
	    System.out.println(rf.readBoolean());
	    System.out.println((char)rf.readByte());
	    System.out.println((char)rf.readByte());
	    System.out.println(rf.readChar());
	    System.out.println(rf.readFloat());
	    System.out.println(rf.readInt());
	    System.out.println(rf.readShort());
	    System.out.println(rf.readUTF());
	    rf.close();
	  }
	  public static void main(String[] args)
	  throws IOException {
	    RandomAccessFile rf = new RandomAccessFile(file, "rw");
//	    for(int i = 0; i < 7; i++)
//	      rf.writeDouble(i*1.414);
	    //Begin writing
	    rf.writeBoolean(true);
	    rf.writeBytes("12");
	    rf.writeChar('c');
	    rf.writeFloat(3);
	    rf.writeInt(5);
	    rf.writeShort(7);
	    rf.writeUTF("The end of the file");
	    rf.close();
	    display();
	    rf = new RandomAccessFile(file, "rw");
	    rf.seek(9);
	    rf.writeInt(11);
	    rf.close();
	    display();
	  }
}
