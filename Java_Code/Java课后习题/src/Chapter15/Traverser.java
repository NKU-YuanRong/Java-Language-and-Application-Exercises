package Chapter15;

import java.io.File;
import java.util.Scanner;

public class Traverser {
	static long Storage = 0;//�ļ����ڴ�
	static int FileNumber = 0;//�ļ�������
	static int DirectoryNumber = 0;//�ļ���������
	
	static void view(File AimFile){
		//�ݹ�����ļ���AimFile�ĺ���
		File[] files = AimFile.listFiles();//File�����¼�ļ�AimFile�������ļ����ļ���
		if(files == null)return;//��Ϊ�գ�ֱ�ӷ���
		for(int i = 0; i < files.length; i++){
			/*
			 * ���¿�ʼ������
			 * ���������ļ�����ݹ����view����������DirectoryNumber++
			 * �������ļ��������·�������֣�Storage += ���ļ��ڴ棬FileNumber++
			 */
			if(files[i].isDirectory()){
				DirectoryNumber++;
				view(files[i]);
				continue;
			}
			Storage += files[i].length();
			FileNumber++;
			System.out.println(files[i].getPath() + files[i].getName());
		}
	}
	
	public static void main(String[] args){
		System.out.println("������Ҫ�������ļ���·��: ");
		String Path;//Ҫ�������ļ���·��
		Scanner sc = new Scanner(System.in);
		Path = sc.nextLine();
		File f = new File(Path);
		sc.close();
		view(f);
		System.out.println("�ļ�������: " + DirectoryNumber);
		System.out.println("�ļ����� : " + FileNumber);
		System.out.println("���ڴ�: " + Storage/1024/1024/1024 + "GB");
	}
}
