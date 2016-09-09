#include <iostream>
//#include <iomanip>
using namespace std;

const int MAXN = 100000;
int bounds[MAXN][2];
double prob[MAXN];

int Codeforces621C() {
	int n, p;
	cin >> n >> p;
	for(int i = 0; i < n; i++)
	{
		cin >> bounds[i][0] >> bounds[i][1];
		int numP = bounds[i][1]/p - (bounds[i][0] - 1)/p;
		prob[i] = ((double) numP)/(bounds[i][1] - bounds[i][0] + 1);
	}
	double output = 0.0;
	for(int i = 0; i < n; i++)
	{
		int next = (i + 1)%n;
		output += 2000.0*(prob[i] + prob[next] - prob[i]*prob[next]);
	}
	cout.precision(20);
	cout << output << "\n";
}
