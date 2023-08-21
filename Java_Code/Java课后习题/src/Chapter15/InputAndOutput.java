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
		 * һЩ��д���ԣ�
		 * canRead()�Ƿ�ɶ���
		 * canWrite()�Ƿ��д��
		 * long length()���ȣ�
		 * String[] list()Ŀ¼�������ļ���
		 * isFile()���ļ���
		 * isDirectory()��Ŀ¼��
		 * renameTo(File new)������
		 * delete()ɾ��
		 * mkdir()�½�Ŀ¼
		 */
		
		//InputStream������
		/*
		 * abstract int read()����һ���ֽڣ�������255��
		 * int read(byte[] b)���ֽ�����b����������ʵ�ʶ�������Ч��������
		 * int read(byte[] b,int off,int len)
		 * skip(long n)����n���ֽڲ���
		 * boolean markSupported()���Ƿ�֧��mark
		 * mark(int readlimit)�ڵ�ǰλ�������
		 * reset() �ص����һ�����ı�Ǵ�
		 * close()�ر����������ͷ���˴����������ӵ�ϵͳ��Դ
		 */
		
		
		//OutputStream�����
		/*
		 * write(int b)�������дһ���ֽ�
		 * write(byte[] b)
		 * void write(byte[] b, int off, int len)
		 * flush()ˢ���������ǿ���������������
		 * close()
		 */
		
	}
}

