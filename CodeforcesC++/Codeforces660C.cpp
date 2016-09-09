#include <iostream>
using namespace std;

int Codeforces660C() {
	int n, k;
	int a[300010];
	cin >> n >> k;
	for(int i = 0; i < n; i++)
		cin >> a[i];
	int head, tail, maxHead, maxTail, numZeroes;
	head = 0;
	tail = 0;
	maxHead = 0;
	maxTail = 0;
	numZeroes = 0;
	while(tail < n)
	{
		if(a[tail] == 0)
			numZeroes++;
		tail++;
		if(numZeroes > k)
		{
			while(numZeroes > k)
			{
				numZeroes -= 1 - a[head];
				head++;
			}
		}
		if(tail - head > maxTail - maxHead)
		{
			maxTail = tail;
			maxHead = head;
		}
	}
	for(int i = maxHead; i < maxTail; i++)
		a[i] = 1;
	cout << (maxTail - maxHead) << "\n";
	for(int i = 0; i < n; i++)
		cout << a[i] << " ";
	cout << "\n";
}
