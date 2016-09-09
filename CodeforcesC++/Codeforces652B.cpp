#include <stdio.h>
//#include <cstdlib>
#include <algorithm>
#include <vector>
using namespace std;

int Codeforces652B() {
	int a[1010];
	int n;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	sort(a, a + n);
	for(int i = 1; i < n - 1; i+=2)
		swap(a[i], a[i + 1]);
	for(int i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
	return 0;
}
