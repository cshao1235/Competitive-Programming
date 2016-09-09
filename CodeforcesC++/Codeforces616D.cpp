#include <stdio.h>
using namespace std;

int Codeforces616D() {
	int a[1000010];
	int c[1000010];
	int n, k;
	scanf("%d %d", &n, &k);
	for(int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	int head = 0;
	int tail = 0;
	int maxHead = 0;
	int maxTail = 0;
	int count = 0;
	while(tail != n)
	{
		if(c[a[tail]] == 0)
			count++;
		c[a[tail]]++;
		while(count > k)
		{
			c[a[head]]--;
			if(c[a[head]] == 0)
				count--;
			head++;
		}
		if(tail - head > maxTail - maxHead)
		{
			maxTail = tail;
			maxHead = head;
		}
		tail++;
	}
	printf("%d %d", maxHead + 1, maxTail + 1);
}
