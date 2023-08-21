package Calculator;

public class Calcu {
	public static String CalcuUnit(String Input){
		String temp = "";
		//用于暂时存放运算符号或一个参与运算的数字
		char stack[] = new char[100];
		//栈，用于中缀转后缀
		String ReverseOption[] = new String[50];
		//存储由中缀表达式转化为的后缀表达式
		String Result[] = new String[50];
		//进行中缀表达式的计算
		int top = -1;
		//栈顶指针
		int j = 0;
		//中缀表达式指针
		for(int i = 0; i < Input.length(); i++){
			if(".0321654987".indexOf(Input.charAt(i)) >= 0){
				//若输入为数字(包括小数点)，将整个数字压入栈中
				temp = "";
				//重置temp，存储数字
				for(; i < Input.length()&&".0321654987".indexOf(Input.charAt(i)) >= 0; i++){
					temp += Input.charAt(i);
				}
				i--;
				ReverseOption[j] = temp;
				j++;
			}
			else if("(".indexOf(Input.charAt(i)) >= 0){
				//若输入为左括号，直接压栈
				top++;
				stack[top] = Input.charAt(i);
			}
			else if(")".indexOf(Input.charAt(i)) >= 0){
				//若输入为右括号，则返回寻找匹配的左括号
				for(;;){
					if(stack[top] != '('){
						ReverseOption[j] = "" + stack[top];
						j++;
						top--;
					}
					else{
						top--;
						break;
					}
				}
			}
			else if("*%÷".indexOf(Input.charAt(i)) >= 0){
				//若输入为高优先级运算符
				if(top == -1){
					//栈空则直接压栈
					top++;
					stack[top] = Input.charAt(i);
				}
				else{
					//若栈不为空，则考虑栈顶元素
					if("*%÷".indexOf(stack[top]) >= 0){
						//栈顶元素也为高优先级运算符，将栈顶运算符先放入中缀表达式，再将当前运算符压栈
						ReverseOption[j] = "" + stack[top];
						j++;
						stack[top] = Input.charAt(i);
					}
					else if("(".indexOf(stack[top]) >= 0){
						//栈顶为左括号，直接压栈
						top++;
						stack[top] = Input.charAt(i);
					}
					else if("+-".indexOf(stack[top]) >= 0){
						//栈顶为低优先级运算符，直接压栈
						top++;
						stack[top] = Input.charAt(i);
					}
				}
			}
			else if("+-".indexOf(Input.charAt(i)) >= 0){
				//若输入为低优先级运算符
				if(top == -1){
					//空栈直接入栈
					top++;
					stack[top] = Input.charAt(i);
				}
				else{
					//栈不为空
					if("*%÷+-".indexOf(stack[top]) >= 0){
						//栈顶为运算符，直接压栈（低优先级运算符不用考虑优先级了，反正是最后的）
						ReverseOption[j] = "" + stack[top];
						j++;
						stack[top] = Input.charAt(i);
					}
					else if("(".indexOf(stack[top]) >= 0){
						//若为左括号，直接压栈
						top++;
						stack[top] = Input.charAt(i);
					}
				}
			}
		}
		for(; top != -1; ){
			//将剩余元素压栈
			ReverseOption[j] = "" + stack[top];
			j++;
			top--;
		}
		top = -1;
		
		//-------------------------------
		for(String s : ReverseOption){
			System.out.print(s);
		}
		//-------------------------------
		
		//重置栈指针top，使其指向Result栈，开始计算ReverseOption中的后缀表达式
		for(j = 0; ReverseOption[j] != null; j++){
			if("+-*%÷".indexOf(ReverseOption[j]) < 0){
				//若输入为数字，直接压栈
				top++;
				Result[top] = ReverseOption[j];
			}
			if("+-*%÷".indexOf(ReverseOption[j]) >= 0){
				//若输入为运算符，分情况
				double x, y, z;//对于拆解后的每个小运算，x和y作为运算数，z保存运算结果
				x = Double.parseDouble(Result[top]);
				top--;
				y = Double.parseDouble(Result[top]);
				top--;
				
				if("+".indexOf(ReverseOption[j]) >= 0){
					z = x + y;
					top++;
					Result[top] = String.valueOf(z);
				}
				//加法，将x + 的结果保存到栈顶
				
				if("-".indexOf(ReverseOption[j]) >= 0){
					z = y - x;
					top++;
					Result[top] = String.valueOf(z);
				}
				//减法，将x - y的结果保存到栈顶
				
				if("*".indexOf(ReverseOption[j]) >= 0){
					z = x * y;
					top++;
					Result[top] = String.valueOf(z);
				}
				//乘法，将x * y的结果保存到栈顶
				
				if("÷".indexOf(ReverseOption[j]) >= 0){
					if(x == 0){
						return "Divisor == 0!";
					}
					else{
						z = y / x;
						top++;
						Result[top] = String.valueOf(z);
					}
				}
				//除法，此处应考虑被除数是否为0，若为0则返回异常
				
				if("%".indexOf(ReverseOption[j]) >= 0){
					if(x == 0){
						return "SparedNumber == 0!";
					}
					else{
						z = y % x;
						top++;
						Result[top] = String.valueOf(z);
					}
				}
				//取余，类似除法考虑0特殊情况
				
			}
		}
		return Result[top];
		//输出Result数组中仅剩的一个值，即运算结果
	}
}
