#include <iostream>
using namespace std;

int Codeforces599A() {
	int d1, d2, d3;
	cin >> d1 >> d2 >> d3;
	int result = min(d1 + d2 + d3, 2*d1 + 2*d2);
	result = min(result, 2*d1 + 2*d3);
	result = min(result, 2*d2 + 2*d3);
	cout << result;
}
