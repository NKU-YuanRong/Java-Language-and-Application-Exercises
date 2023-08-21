//BackGround.java
package CDshop;
import java.util.*;

public class BackGround {
	private CDBook cdBook= new CDBook();
	private ClientBook clBook = new ClientBook();
	void printManu(){
		System.out.println("Manu :");
		System.out.println("1: 进货CD");
		System.out.println("2: 统计库存");
		System.out.println("3: 添加用户");
		System.out.println("4: 删除用户");
		System.out.println("5: 用户购买CD");
		System.out.println("6: 用户租借CD");
		System.out.println("7: 用户归还CD");
		System.out.println("8: 统计用户");
		System.out.println("9: 退出程序");
	}
	public void start(){
		Scanner In = new Scanner(System.in);
		printManu();
		int judge;
		while(true){
			System.out.println("请输入下一个操作");
			judge = In.nextInt();
			switch(judge){
			case 1:
				System.out.println("Please input id, name, price and num: ");
				int CDid = In.nextInt();
				String CDname = In.next();
				int CDprice = In.nextInt();
				int CDnum = In.nextInt();
				stockCD(CDid, CDname, CDprice, CDnum);
				break;
			case 2:
				System.out.println(cdBook);
				break;
			case 3:
				System.out.println("Please input id, name and balence: ");
				int ClientId = In.nextInt();
				String ClientName = In.next();
				int ClientBalence = In.nextInt();
				addClient(ClientId, ClientName, ClientBalence);
				break;
			case 4:
				System.out.println("Please input id: ");
				int id = In.nextInt();
				removClient(id);
				break;
			case 5:
				System.out.println("Please input Client id, CD id, and CD number: ");
				int ClienId = In.nextInt();
				int CDId = In.nextInt();
				int CDNumber = In.nextInt();
				buyCD(ClienId, CDId, CDNumber);
				break;
			case 6:
				System.out.println("Please input Client id, CD id, and CD number: ");
				int ClieId = In.nextInt();
				int cdid = In.nextInt();
				int CDnumber = In.nextInt();
				borrowCD(ClieId, cdid, CDnumber);
				break;
			case 7:
				System.out.println("Please input Client id and CD id: ");
				int CliId = In.nextInt();
				int cDid = In.nextInt();
				returnCD(CliId, cDid);
				break;
			case 8:
				System.out.println(clBook);
				break;
			case 9:
				In.close();
				return;
			}
		}
	}
	public void stockCD(int id, String name, int price, int num){
		cdBook.addCD(new CD(id, name, price, num));
		System.out.println("成功添加！");
	}//进货CD
	public void TackBack(CD d){
		cdBook.addCD(d);
	}
	public void addClient(int id, String name, int balence){
		clBook.addClient(new Client(id, name, balence));
		System.out.println("添加成功!");
	}//添加用户
	public void removClient(int id){
		clBook.removeClient(id);
		System.out.println("删除成功!");
	}//删除用户
	public void buyCD(int ClId, int CDid, int num){
		if(!clBook.findClient(ClId)){
			System.out.println("用户不存在!");
			return;
		}
		if(cdBook.CDnum(CDid) < num){
			System.out.println("CD数量不足!");
			return;
		}
		if(clBook.getBalence(ClId) < num * cdBook.GetPrice(CDid)){
			System.out.println("余额不足!");
			return;
		}
		clBook.pay(ClId, num * cdBook.GetPrice(CDid));
		cdBook.sellCD(CDid, num);
		clBook.addCD(ClId, new CD(CDid,cdBook.CDname(CDid),cdBook.CDprice(CDid),num));
		System.out.println("购买成功!");
	}
	public void borrowCD(int ClId, int CDid, int num){
		if(!clBook.findClient(ClId)){
			System.out.println("用户不存在!");
			return;
		}
		if(cdBook.CDnum(CDid) < num){
			System.out.println("CD数量不足!");
			return;
		}
		if(clBook.getBalence(ClId) < num * cdBook.GetPrice(CDid) / 2){
			System.out.println("余额不足!");
			return;
		}
		clBook.pay(ClId, num * cdBook.GetPrice(CDid) / 2);
		cdBook.sellCD(CDid, num);
		clBook.addCD(ClId, new CD(CDid,cdBook.CDname(CDid),cdBook.CDprice(CDid),num));
		System.out.println("租借成功!");
	}
	public void returnCD(int ClId, int CDid){
		if(!clBook.findClient(ClId)){
			System.out.println("用户不存在!");
			return;
		}
		CD d = clBook.returnCD(ClId, CDid);
		TackBack(d);
		System.out.println("归还成功！");
	}
	public static void main(String[] args){
		BackGround a = new BackGround();
		a.start();
	}
}//
