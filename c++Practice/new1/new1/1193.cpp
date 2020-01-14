#include<cstdio>


int main() {

	int n;
	scanf("%d",&n);

	
	int count= 0;
	while (0<n)
	{
		count++;
		//-1 -2 -3 -4 -5 -6 -7
		// 
		n -= count;
		


	}

	if (count % 2 == 0) {
		                //n이 음수인데 순서는 4번쨰이더라도 3/1이렇게 표시되기떄문에 count+n,  n은 그리고 -가됐다면은 count에서 값이 
						// 1-5 이렇게 돼서 -4가됐다면  이게  12이렇게 값이 들어왔다면
		printf("%d/%d", count + n, 1 + (-n));
	}
	else {

		printf("%d/%d", 1 + (-n), count + n);

	}



}