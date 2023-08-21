package Chapter15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputAndOutput {
	public static void main(String[] args){
		File f1 = new File("D:\\FFOutput\newText.txt");
		File f2 = new File(f1,"newText.txt");
		//System.out.println(f2.isFile());
		for(String s : f1.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		})){
			System.out.println(s);
		}
		
		
		/*
		 * 一些读写属性：
		 * canRead()是否可读？
		 * canWrite()是否可写？
		 * long length()长度？
		 * String[] list()目录下所有文件名
		 * isFile()是文件？
		 * isDirectory()是目录？
		 * renameTo(File new)重命名
		 * delete()删除
		 * mkdir()新建目录
		 */
		
		//InputStream输入流
		/*
		 * abstract int read()返回一个字节（不超过255）
		 * int read(byte[] b)把字节数组b读满，返回实际读到的有效数据数量
		 * int read(byte[] b,int off,int len)
		 * skip(long n)跳过n个字节不读
		 * boolean markSupported()流是否支持mark
		 * mark(int readlimit)在当前位置做标记
		 * reset() 回到最近一次做的标记处
		 * close()关闭输入流，释放与此处输入流连接的系统资源
		 */
		
		
		//OutputStream输出流
		/*
		 * write(int b)向输出流写一个字节
		 * write(byte[] b)
		 * void write(byte[] b, int off, int len)
		 * flush()刷新输出流，强制输出缓冲区数据
		 * close()
		 */
		
	}
}

