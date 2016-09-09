#include <iostream>
using namespace std;

int Codeforces607B() {
	int n;
	int c[n][2];
	cin >> n;
	int remaining = n;
	int start = 0;
	int numSteps = 0;
	for(int i = 0; i < n; i++)
	{
		cin >> c[i][0];
		c[i][1] = i + 1;
	}
	c[n - 1][1] = -1;
	int dp[n];
	while(remaining > 0)
	{
		dp[start] = 1;
		int current = start;
		while(current != -1)
		{

		}
	}
}
