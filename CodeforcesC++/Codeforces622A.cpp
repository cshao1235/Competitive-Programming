#include <iostream>
#include <math.h>
using namespace std;

int Codeforces622A() {
	long long int n, k, output;
	cin >> n;
	k = (int) sqrt(8*n + 1) - 1;
	k /= 2;
	output = n - k*(k + 1)/2;
	if(output == 0)
		output = k;
	cout << output;
}
