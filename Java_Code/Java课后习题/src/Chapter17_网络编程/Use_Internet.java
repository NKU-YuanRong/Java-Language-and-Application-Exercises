package Chapter17_网络编程;

public class Use_Internet {
	/*
	 * 统一资源定位符URL
	 * 	用字符串表示Internet网络上的资源的地址
	 * 	包括两部分：
	 * 		使用的协议（http，ftp，gopher等）
	 * 			如我们常见的： http://xxxxxxxxxxxx
	 * 			其中http就是文件传输协议，后面的://是分隔符（分割协议和资源位置）
	 * 		资源位置
	 * 			主机名（或IP地址）
	 * 			端口名
	 * 			路径名，资源文件在主机总的路径
	 * 			引用，指向资源文件的某一个位置
	 */
	
	//Java中的URL类
	/*
	 * 构造函数：
	 * URL url1 = new URL("http://www.nankai.edu.cn");
	 * URL url2 = new URL(url1, "file.html");
	 * 
	 * 获取资源：
	 * 使用对象的openStream()方法返回一个InputStream，用InputStream读取即可
	 * 
	 * 
	 * 使用对象的openConnection()方法，成功即返回一个URLConnectio对象
	 * 读：getInputStream()获得一个数据流
	 * 写：setDoOutput(true),getOutputStream()获取一个输入数据流
	 * 
	 */
	
	//InetAddress类
	/*
	 * 将字符串转换为一个网址
	 * InetAddress ip1 = InetAddress.getByName("202.113.28.6");
	 * InetAddress ip2 = InetAddress.getByName("www.nankai.edu.cn");
	 */
	
	
}
