package homework;

import java.util.Scanner;

public class Compare_nums {
	public static void main(String[] args) {
		int num1,num2,num3;
		int max,mid,min=0;
		
		System.out.print("���� 3���� ���� �Է� �ϼ��� :");
		Scanner num_in = new Scanner(System.in);
		num1 = num_in.nextInt();
		num2 = num_in.nextInt();
		num3 = num_in.nextInt();
		
		//���� ū �� ���
		if(num1>num2 && num1>num3)
		{
			max = num1;
		}
		else if(num2>num1 && num2>num3)
		{
			max = num2;
		}
		else
			max = num3;
		//���� ���� �� ���
		if(num1<num2 && num1<num3)
		{
			min = num1;
		}
		else if(num2<num1 && num2<num3)
		{
			min = num2;
		}
		else
		{
			min = num3;
		}
		//�߰� �� ��� 
		if(num1<max && num1>min)
		{
			mid = num1;
		}
		else if(num2<max && num2>min)
		{
			mid = num2;
		}
		else
			mid = num3;
		
		System.out.println(max + " > " + mid + " > " + min);
	}

}
