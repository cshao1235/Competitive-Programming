#include<iostream>
using namespace std;

int Codeforces702A() {
	int n;
	int a[100000];
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> a[i];
	int max = 1;
	int current = 1;
	for(int i = 1; i < n; i++) {
		if(a[i] > a[i - 1])
			current++;
		else
			current = 1;
		if(current > max)
			max = current;
	}
	cout << max;
}
