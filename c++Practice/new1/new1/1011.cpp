#include<cstdio>
#include<math.h>



int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		int x, y;
		long long temp = 1;
		scanf("%d %d", &x, &y);
		while (temp * temp <= (y - x)) {

			temp++;
		}
		temp--;
		//�ִ�Ÿ��� n^2�����  ����ȸ���� �޶����� �������Ÿ����� �� �ִ�Ÿ����ѱ���� ��� ������ �������� �׸�ŭ ���� �� ������ �������������� 
		//�Ÿ��� ���Ҵٴ¶��̴� �׸�ŭ +1�� �����̸�  �ɰ��̴�. 
		long long  remain = (y - x) -(temp * temp);
		remain = (long long)ceil((double)remain / (double)temp);
		printf("%lld\n", 2 * temp - 1 + remain);
	}
}