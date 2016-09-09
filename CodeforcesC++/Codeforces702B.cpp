#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int n;
	int a[100000];
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> a[i];
	sort(0, n, a);
	int count = 0;
	for(int i = 0; i < n; i++) {
		for(int k = 1; k <= 31; k++) {
			int sum = 1 << k;
			int val = sum - a[i];

		}
	}
}
