package DataBaseWork;

public class Vars {
	public static MainPanel mainpanel = new MainPanel();
	public static DatabaseConnector connector = new DatabaseConnector();
	public static OperatingPanel operatingpanel = new OperatingPanel();
	public static SysFrame sysframe;
	public static void main(String[] args) {
		sysframe = new SysFrame();
	}
}
