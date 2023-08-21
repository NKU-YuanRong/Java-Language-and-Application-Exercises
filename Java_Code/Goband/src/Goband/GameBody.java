package Goband;
import java.util.*;

public class GameBody {
	private static int ChessBoard[][] = new int[15][15];//棋盘默认初始化为0，下棋之后1代表黑子，-1代表白子
	private static int steps = 1;//记录游戏走过的步数
	private static boolean GameIsOn;//static布尔变量，用于标记游戏开始/结束
	private static boolean GameTest(int x, int y, int val){
		int count = 0;//count用于记录连子数量，若达到5则游戏结束
		
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
		//横向判断
		
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
		//纵向判断
		
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
		//左上到右下判断
		
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
		}//右上到左下判断
		
		return true;//若连子数量并未达到5，则游戏继续
	}
	//每下一步棋，均检测游戏是否结束
	
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
	//用于辅助printChess,美化棋盘输出（棋盘空白处为'-'，黑子为'#'，白子为'&'）
	private static void printChess(){
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 14; j++){
				System.out.print(printAux(ChessBoard[i][j]) + " ");
			}
			System.out.println(printAux(ChessBoard[i][14]));
		}
	}
	//向屏幕输出当前棋局
	private static void print(Object a){
		System.out.println(a);
	}
	//简化输出
	
	private static Stack<Chess> EveryStep = new Stack<Chess>();
	//栈，存放每一步走的棋，以便后续悔棋以及其他特性实现
	
	public static void main(String[] args){
		GameIsOn = false;
		//游戏处于关闭阶段
		print("Input 1 to Start Goband: ");
		Scanner in = new Scanner(System.in);
		if(in.nextInt() == 1){
			GameIsOn = true;
			print("游戏开始，黑色先手，悔棋请输入-1 -1");
		}//程序开启后，还需要输入1来进入游戏的运行阶段（否则无法进行游戏）
		
		while(GameIsOn){
			printChess();
			if(steps % 2 == 1){ //奇数步黑手走棋，偶数步白手走棋
				print("轮到黑方下棋，请输入下棋坐标x y: ");
				int tempX = in.nextInt();
				int tempY = in.nextInt();
				if(tempX > -1 && tempX < 15 && tempY > -1 && tempY < 15){//判断输入合法性，合法则正常走棋
					if(ChessBoard[tempX][tempY] == 0){//判断所下位置是否已经有棋子了
						ChessBoard[tempX][tempY] = 1;
						GameIsOn = GameTest(tempX, tempY, 1);
						EveryStep.push(new Chess(tempX, tempY));
						steps++;
					}
					else{
						print("无法下在此处，请重新下棋");
					}
				}
				else{//若输入坐标在棋盘之外，则进行悔棋
					if(EveryStep.empty()){
						print("无法悔棋！请继续下棋");
					}
					else{
						Chess a = EveryStep.pop();
						ChessBoard[a.x][a.y] = 0;
						//printChess();
						steps--;
						print("悔棋成功！");
					}
				}
			}
			else{
				print("轮到白方下棋，请输入下棋坐标x y: ");
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
						print("无法下在此处，请重新下棋");
					}
				}
				else{
					if(EveryStep.empty()){
						print("无法悔棋！请继续下棋");
					}
					else{
						Chess a = EveryStep.pop();
						ChessBoard[a.x][a.y] = 0;
						//printChess();
						steps--;
						print("悔棋成功！");
					}
				}
			}
		}
		//while的每一次循环均代表一次走棋or悔棋，若某次走棋之后游戏结束，则循环也结束，进入游戏结束阶段
		
		in.close();//关闭Scanner
		printChess();//打印最终棋局
		if(steps % 2 == 1){
			print("游戏结束，白棋胜利！");
		}
		else{
			print("游戏结束，黑棋胜利！");
		}//根据步数即可判断胜利方
		//输出胜者
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
//Chess类，压栈记录每一步走棋
