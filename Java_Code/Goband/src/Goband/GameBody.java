package Goband;
import java.util.*;

public class GameBody {
	private static int ChessBoard[][] = new int[15][15];//����Ĭ�ϳ�ʼ��Ϊ0������֮��1������ӣ�-1�������
	private static int steps = 1;//��¼��Ϸ�߹��Ĳ���
	private static boolean GameIsOn;//static�������������ڱ����Ϸ��ʼ/����
	private static boolean GameTest(int x, int y, int val){
		int count = 0;//count���ڼ�¼�������������ﵽ5����Ϸ����
		
		for(int i = x - 4; i < x + 5; i++){
			if(i < 0 || i > 14){
				continue;
			}
			if(ChessBoard[i][y] == val){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return false;
			}
		}
		count = 0;
		//�����ж�
		
		for(int i = y - 4; i < y + 5; i++){
			if(i < 0 || i > 14){
				continue;
			}
			if(ChessBoard[x][i] == val){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return false;
			}
		}
		count = 0;
		//�����ж�
		
		for(int i = -4; i < 5; i++){
			if(x + i < 0 || x + i > 14 ||y + i < 0 || y + i > 14){
				continue;
			}
			if(ChessBoard[x + i][y + i] == val){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return false;
			}
		}
		count = 0;
		//���ϵ������ж�
		
		for(int i = -4; i < 5; i++){
			if(x + i < 0 || x + i > 14 || y - i < 0 || y - i > 14){
				continue;
			}
			if(ChessBoard[x + i][y - i] == val){
				count++;
			}
			else{
				count = 0;
			}
			if(count == 5){
				return false;
			}
		}//���ϵ������ж�
		
		return true;//������������δ�ﵽ5������Ϸ����
	}
	//ÿ��һ���壬�������Ϸ�Ƿ����
	
	private static char printAux(int a){
		if(a == 0){
			return '-';
		}
		else if(a == 1){
			return '#';
		}
		else{
			return '&';
		}
	}
	//���ڸ���printChess,����������������̿հ״�Ϊ'-'������Ϊ'#'������Ϊ'&'��
	private static void printChess(){
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 14; j++){
				System.out.print(printAux(ChessBoard[i][j]) + " ");
			}
			System.out.println(printAux(ChessBoard[i][14]));
		}
	}
	//����Ļ�����ǰ���
	private static void print(Object a){
		System.out.println(a);
	}
	//�����
	
	private static Stack<Chess> EveryStep = new Stack<Chess>();
	//ջ�����ÿһ���ߵ��壬�Ա���������Լ���������ʵ��
	
	public static void main(String[] args){
		GameIsOn = false;
		//��Ϸ���ڹرս׶�
		print("Input 1 to Start Goband: ");
		Scanner in = new Scanner(System.in);
		if(in.nextInt() == 1){
			GameIsOn = true;
			print("��Ϸ��ʼ����ɫ���֣�����������-1 -1");
		}//�������󣬻���Ҫ����1��������Ϸ�����н׶Σ������޷�������Ϸ��
		
		while(GameIsOn){
			printChess();
			if(steps % 2 == 1){ //�������������壬ż������������
				print("�ֵ��ڷ����壬��������������x y: ");
				int tempX = in.nextInt();
				int tempY = in.nextInt();
				if(tempX > -1 && tempX < 15 && tempY > -1 && tempY < 15){//�ж�����Ϸ��ԣ��Ϸ�����������
					if(ChessBoard[tempX][tempY] == 0){//�ж�����λ���Ƿ��Ѿ���������
						ChessBoard[tempX][tempY] = 1;
						GameIsOn = GameTest(tempX, tempY, 1);
						EveryStep.push(new Chess(tempX, tempY));
						steps++;
					}
					else{
						print("�޷����ڴ˴�������������");
					}
				}
				else{//����������������֮�⣬����л���
					if(EveryStep.empty()){
						print("�޷����壡���������");
					}
					else{
						Chess a = EveryStep.pop();
						ChessBoard[a.x][a.y] = 0;
						//printChess();
						steps--;
						print("����ɹ���");
					}
				}
			}
			else{
				print("�ֵ��׷����壬��������������x y: ");
				int tempX = in.nextInt();
				int tempY = in.nextInt();
				if(tempX > -1 && tempX < 15 && tempY > -1 && tempY < 15){
					if(ChessBoard[tempX][tempY] == 0){
						ChessBoard[tempX][tempY] = -1;
						GameIsOn = GameTest(tempX, tempY, -1);
						EveryStep.push(new Chess(tempX, tempY));
						steps++;
					}
					else{
						print("�޷����ڴ˴�������������");
					}
				}
				else{
					if(EveryStep.empty()){
						print("�޷����壡���������");
					}
					else{
						Chess a = EveryStep.pop();
						ChessBoard[a.x][a.y] = 0;
						//printChess();
						steps--;
						print("����ɹ���");
					}
				}
			}
		}
		//while��ÿһ��ѭ��������һ������or���壬��ĳ������֮����Ϸ��������ѭ��Ҳ������������Ϸ�����׶�
		
		in.close();//�ر�Scanner
		printChess();//��ӡ�������
		if(steps % 2 == 1){
			print("��Ϸ����������ʤ����");
		}
		else{
			print("��Ϸ����������ʤ����");
		}//���ݲ��������ж�ʤ����
		//���ʤ��
	}
}



class Chess{
	public Chess(int ix, int iy){
		x = ix;
		y = iy;
	}
	public int x;
	public int y;
}
//Chess�࣬ѹջ��¼ÿһ������
