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
		                //n�� �����ε� ������ 4�����̴��� 3/1�̷��� ǥ�õǱ⋚���� count+n,  n�� �׸��� -���ƴٸ��� count���� ���� 
						// 1-5 �̷��� �ż� -4���ƴٸ�  �̰�  12�̷��� ���� ���Դٸ�
		printf("%d/%d", count + n, 1 + (-n));
	}
	else {

		printf("%d/%d", 1 + (-n), count + n);

	}



}