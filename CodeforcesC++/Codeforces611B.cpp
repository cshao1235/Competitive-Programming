#include <iostream>
using namespace std;

long long powersOf2[70];

int Codeforces611B() {
	long long a, b;
	cin >> a >> b;
	//cout << a << " " << b << " \n";
	int counter = 0;
	for(int i = 0; i < 63; i++)
	{
		powersOf2[i] = 1;
		powersOf2[i] = (powersOf2[i] << i);
	}
	//cout << powersOf2[62] << " ";
	//bool good = true;
	for(int yearCounter = 2; yearCounter < 63; yearCounter++)
	{
		long long max = powersOf2[yearCounter] - 1;
		for(int i = yearCounter - 2; i >= 0; i--)
		{
			long long value = max - powersOf2[i];
			if(value >= a && value <= b)
			{
				//cout << value << " ";
				counter++;
			}
		}
	}
	cout << counter;
}
