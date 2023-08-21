//BackGround.java
package CDshop;
import java.util.*;

public class BackGround {
	private CDBook cdBook= new CDBook();
	private ClientBook clBook = new ClientBook();
	void printManu(){
		System.out.println("Manu :");
		System.out.println("1: ����CD");
		System.out.println("2: ͳ�ƿ��");
		System.out.println("3: ����û�");
		System.out.println("4: ɾ���û�");
		System.out.println("5: �û�����CD");
		System.out.println("6: �û����CD");
		System.out.println("7: �û��黹CD");
		System.out.println("8: ͳ���û�");
		System.out.println("9: �˳�����");
	}
	public void start(){
		Scanner In = new Scanner(System.in);
		printManu();
		int judge;
		while(true){
			System.out.println("��������һ������");
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
		System.out.println("�ɹ���ӣ�");
	}//����CD
	public void TackBack(CD d){
		cdBook.addCD(d);
	}
	public void addClient(int id, String name, int balence){
		clBook.addClient(new Client(id, name, balence));
		System.out.println("��ӳɹ�!");
	}//����û�
	public void removClient(int id){
		clBook.removeClient(id);
		System.out.println("ɾ���ɹ�!");
	}//ɾ���û�
	public void buyCD(int ClId, int CDid, int num){
		if(!clBook.findClient(ClId)){
			System.out.println("�û�������!");
			return;
		}
		if(cdBook.CDnum(CDid) < num){
			System.out.println("CD��������!");
			return;
		}
		if(clBook.getBalence(ClId) < num * cdBook.GetPrice(CDid)){
			System.out.println("����!");
			return;
		}
		clBook.pay(ClId, num * cdBook.GetPrice(CDid));
		cdBook.sellCD(CDid, num);
		clBook.addCD(ClId, new CD(CDid,cdBook.CDname(CDid),cdBook.CDprice(CDid),num));
		System.out.println("����ɹ�!");
	}
	public void borrowCD(int ClId, int CDid, int num){
		if(!clBook.findClient(ClId)){
			System.out.println("�û�������!");
			return;
		}
		if(cdBook.CDnum(CDid) < num){
			System.out.println("CD��������!");
			return;
		}
		if(clBook.getBalence(ClId) < num * cdBook.GetPrice(CDid) / 2){
			System.out.println("����!");
			return;
		}
		clBook.pay(ClId, num * cdBook.GetPrice(CDid) / 2);
		cdBook.sellCD(CDid, num);
		clBook.addCD(ClId, new CD(CDid,cdBook.CDname(CDid),cdBook.CDprice(CDid),num));
		System.out.println("���ɹ�!");
	}
	public void returnCD(int ClId, int CDid){
		if(!clBook.findClient(ClId)){
			System.out.println("�û�������!");
			return;
		}
		CD d = clBook.returnCD(ClId, CDid);
		TackBack(d);
		System.out.println("�黹�ɹ���");
	}
	public static void main(String[] args){
		BackGround a = new BackGround();
		a.start();
	}
}//
