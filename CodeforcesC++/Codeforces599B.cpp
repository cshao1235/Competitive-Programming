#include <iostream>
using namespace std;

int f[100010];
int b[100010];
int decode[100010];
int output[100010];

int Codeforces599B() {
	int n, m;
	cin >> n >> m;
	for(int i = 0; i < n; i++)
		cin >> f[i];
	for(int i = 0; i < m; i++)
		cin >> b[i];
	for(int i = 0; i < n; i++)
		decode[i] = -1;
	for(int i = 0; i < n; i++)
	{
		if(decode[f[i] - 1] == -1)
			decode[f[i] - 1] = i + 1;
		else
			decode[f[i] - 1] = -2;
	}
	int counter = 0;
	bool good = true;
	for(int i = 0; i < m; i++)
	{
		if(decode[b[i] - 1] == -1)
		{
			cout << "Impossible";
			good = false;
			break;
		}
	}
	if(good)
	{
		for(int i = 0; i < m; i++)
		{
			if(decode[b[i] - 1] == -2)
			{
				cout << "Ambiguity";
				good = false;
				break;
			}
		}
	}
	if(good)
	{
		for(int i = 0; i < m; i++)
		{
			output[counter] = decode[b[i] - 1];
			counter++;
		}
		cout << "Possible\n";
				for(int i = 0; i < m; i++)
					cout << output[i] << " ";
	}
}
