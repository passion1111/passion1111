#include<cstdio>

void test() {
	int DP[10036] = { 0, };

	for (int i = 1; i <=10000; i++)
	{
	int temp = i;
	int total = i;
	if (temp < 10) {
		total += i;
	}
	else {
		while (temp / 10) {
			total += temp % 10;
			temp /= 10;



		}
		total += temp;


	}


		DP[total] = total;


	}
	for (int i = 1; i <= 10000; i++) {
		if (DP[i] == 0)printf("%d\n", i);
	}


}

int main() {

	test();
	//int DP[10036] = { 0, };

	//for (int i = 1; i < 10000; i++)
	//{
	//	int temp = i;   //����� i��  18
	//	int total = i;  //�� i��       18 

	//	    
	//	if (temp < 10) {
	//		total += temp;
	//	}
	//	else {

	//	while (temp / 10) {
	//	                             
	//	
	//			         
	//		total += temp%10;
	//		temp /= 10;           
	//	}
	//		total += temp;
	//	}
	//	     
	//	
	//	DP[total] = total;
	//	// 9 9 9 9 
	//	//��� i���� ���� �۴ٴ� Ư¡�� ����  total�� ���� 9999�ϰ�� 10035�� �Ѿ������ 


	//}


	//for (int i = 1; i < 10000; i++) {
	//	if (DP[i] == 0) printf("%d\n", i);
	//}


}