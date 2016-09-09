/*#include <stdio.h>
using namespace std;

int Codeforces622B() {
	int h, m, a;
	int h1, m1;
	scanf("%d:%d", &h, &m);
	scanf("%d", &a);
	int numHours = a/60;
	a %= 60;
	if(a + m >= 60)
		numHours++;
	m1 = (a + m)%60;
	h1 = (h + numHours)%24;
	printf("%02d:%02d", h1, m1);
}*/
