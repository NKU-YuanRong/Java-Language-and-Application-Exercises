package Chapter15;

import java.io.File;
import java.util.Scanner;

public class Traverser {
	static long Storage = 0;//文件总内存
	static int FileNumber = 0;//文件总数量
	static int DirectoryNumber = 0;//文件夹总数量
	
	static void view(File AimFile){
		//递归遍历文件夹AimFile的函数
		File[] files = AimFile.listFiles();//File数组记录文件AimFile中所有文件和文件夹
		if(files == null)return;//若为空，直接返回
		for(int i = 0; i < files.length; i++){
			/*
			 * 以下开始遍历：
			 * 若遇到子文件夹则递归调用view函数遍历，DirectoryNumber++
			 * 若遇到文件则输出其路径和名字，Storage += 该文件内存，FileNumber++
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
		System.out.println("请输入要遍历的文件夹路径: ");
		String Path;//要遍历的文件夹路径
		Scanner sc = new Scanner(System.in);
		Path = sc.nextLine();
		File f = new File(Path);
		sc.close();
		view(f);
		System.out.println("文件夹总数: " + DirectoryNumber);
		System.out.println("文件总数 : " + FileNumber);
		System.out.println("总内存: " + Storage/1024/1024/1024 + "GB");
	}
}
