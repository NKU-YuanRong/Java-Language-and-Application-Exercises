package Calculator;

public class Calcu {
	public static String CalcuUnit(String Input){
		String temp = "";
		//������ʱ���������Ż�һ���������������
		char stack[] = new char[100];
		//ջ��������׺ת��׺
		String ReverseOption[] = new String[50];
		//�洢����׺���ʽת��Ϊ�ĺ�׺���ʽ
		String Result[] = new String[50];
		//������׺���ʽ�ļ���
		int top = -1;
		//ջ��ָ��
		int j = 0;
		//��׺���ʽָ��
		for(int i = 0; i < Input.length(); i++){
			if(".0321654987".indexOf(Input.charAt(i)) >= 0){
				//������Ϊ����(����С����)������������ѹ��ջ��
				temp = "";
				//����temp���洢����
				for(; i < Input.length()&&".0321654987".indexOf(Input.charAt(i)) >= 0; i++){
					temp += Input.charAt(i);
				}
				i--;
				ReverseOption[j] = temp;
				j++;
			}
			else if("(".indexOf(Input.charAt(i)) >= 0){
				//������Ϊ�����ţ�ֱ��ѹջ
				top++;
				stack[top] = Input.charAt(i);
			}
			else if(")".indexOf(Input.charAt(i)) >= 0){
				//������Ϊ�����ţ��򷵻�Ѱ��ƥ���������
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
			else if("*%��".indexOf(Input.charAt(i)) >= 0){
				//������Ϊ�����ȼ������
				if(top == -1){
					//ջ����ֱ��ѹջ
					top++;
					stack[top] = Input.charAt(i);
				}
				else{
					//��ջ��Ϊ�գ�����ջ��Ԫ��
					if("*%��".indexOf(stack[top]) >= 0){
						//ջ��Ԫ��ҲΪ�����ȼ����������ջ��������ȷ�����׺���ʽ���ٽ���ǰ�����ѹջ
						ReverseOption[j] = "" + stack[top];
						j++;
						stack[top] = Input.charAt(i);
					}
					else if("(".indexOf(stack[top]) >= 0){
						//ջ��Ϊ�����ţ�ֱ��ѹջ
						top++;
						stack[top] = Input.charAt(i);
					}
					else if("+-".indexOf(stack[top]) >= 0){
						//ջ��Ϊ�����ȼ��������ֱ��ѹջ
						top++;
						stack[top] = Input.charAt(i);
					}
				}
			}
			else if("+-".indexOf(Input.charAt(i)) >= 0){
				//������Ϊ�����ȼ������
				if(top == -1){
					//��ջֱ����ջ
					top++;
					stack[top] = Input.charAt(i);
				}
				else{
					//ջ��Ϊ��
					if("*%��+-".indexOf(stack[top]) >= 0){
						//ջ��Ϊ�������ֱ��ѹջ�������ȼ���������ÿ������ȼ��ˣ����������ģ�
						ReverseOption[j] = "" + stack[top];
						j++;
						stack[top] = Input.charAt(i);
					}
					else if("(".indexOf(stack[top]) >= 0){
						//��Ϊ�����ţ�ֱ��ѹջ
						top++;
						stack[top] = Input.charAt(i);
					}
				}
			}
		}
		for(; top != -1; ){
			//��ʣ��Ԫ��ѹջ
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
		
		//����ջָ��top��ʹ��ָ��Resultջ����ʼ����ReverseOption�еĺ�׺���ʽ
		for(j = 0; ReverseOption[j] != null; j++){
			if("+-*%��".indexOf(ReverseOption[j]) < 0){
				//������Ϊ���֣�ֱ��ѹջ
				top++;
				Result[top] = ReverseOption[j];
			}
			if("+-*%��".indexOf(ReverseOption[j]) >= 0){
				//������Ϊ������������
				double x, y, z;//���ڲ����ÿ��С���㣬x��y��Ϊ��������z����������
				x = Double.parseDouble(Result[top]);
				top--;
				y = Double.parseDouble(Result[top]);
				top--;
				
				if("+".indexOf(ReverseOption[j]) >= 0){
					z = x + y;
					top++;
					Result[top] = String.valueOf(z);
				}
				//�ӷ�����x + �Ľ�����浽ջ��
				
				if("-".indexOf(ReverseOption[j]) >= 0){
					z = y - x;
					top++;
					Result[top] = String.valueOf(z);
				}
				//��������x - y�Ľ�����浽ջ��
				
				if("*".indexOf(ReverseOption[j]) >= 0){
					z = x * y;
					top++;
					Result[top] = String.valueOf(z);
				}
				//�˷�����x * y�Ľ�����浽ջ��
				
				if("��".indexOf(ReverseOption[j]) >= 0){
					if(x == 0){
						return "Divisor == 0!";
					}
					else{
						z = y / x;
						top++;
						Result[top] = String.valueOf(z);
					}
				}
				//�������˴�Ӧ���Ǳ������Ƿ�Ϊ0����Ϊ0�򷵻��쳣
				
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
				//ȡ�࣬���Ƴ�������0�������
				
			}
		}
		return Result[top];
		//���Result�����н�ʣ��һ��ֵ����������
	}
}
