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
	//	int temp = i;   //계산할 i값  18
	//	int total = i;  //총 i값       18 

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
	//	//적어도 i보다 값이 작다는 특징이 있음  total의 값은 9999일경우 10035를 넘어가지않음 


	//}


	//for (int i = 1; i < 10000; i++) {
	//	if (DP[i] == 0) printf("%d\n", i);
	//}


}