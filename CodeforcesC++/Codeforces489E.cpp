#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int v[1010];
int restPoints[1010][2];
double dp[1010][2];

int Codeforces489E() {
	int n;
	double l;
	cin >> n >> l;
	//int restPoints[n + 1][2];
	for(int i = 1; i <= n; i++)
		cin >> restPoints[i][0] >> restPoints[i][1];
	double min = 0.0;
	double max = 100000.0;
	double med = (min + max)/2.0;
	//double dp[n + 1][2];
	for(int i = 0; i < 45; i++)
	{
		med = (min + max)/2.0;
		dp[0][0] = 0;
		dp[0][1] = -1;
		for(int j = 1; j <= n; j++)
		{
			double minVal = 100000000.0;
			int minIndex = 0;
			for(int k = 0; k < j; k++)
			{
				double value = dp[k][0] + sqrt(abs(restPoints[j][0] - restPoints[k][0] - l));
				if(value < minVal)
				{
					minVal = value;
					minIndex = k;
				}
			}
			minVal -= med*restPoints[j][1];
			dp[j][0] = minVal;
			dp[j][1] = minIndex;
		}
		if(dp[n][0] < 0)
			max = med;
		else
			min = med;
	}
	//cout << med << "\n";
	int current = n;
	//int v[n];
	int tail = 0;
	while(current != 0)
	{
		v[tail] = current;
		tail++;
		current = dp[current][1];
	}
	//cout << v.size() << "\n";
	while(tail > 0)
	{
		cout << v[tail - 1] << " ";
		tail--;
	}
	return 0;
}
