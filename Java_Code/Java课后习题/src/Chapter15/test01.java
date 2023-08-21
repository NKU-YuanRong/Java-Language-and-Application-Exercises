package Chapter15;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class test01 {
	
	public static void main(String[] args){
		File path = new File(".");
		String[] list;
		if(args.length == 0){
			list = path.list();
		}
		else{
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String s : list){
			System.out.println(s);
		}
	}
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	
	public DirFilter(String regix) {
		super();
		this.pattern = Pattern.compile(regix);
	}

	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
	}
	
}