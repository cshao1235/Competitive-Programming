#include <iostream>
#include <string>
using namespace std;

int Codeforces628B() {
	string s;
	cin >> s;
	long long int output = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if((s[i] - '0') % 4 == 0)
			output++;
	}
	for(int i = 0; i < s.length() - 1; i++)
	{
		if(((s[i] - '0') * 10 + (s[i + 1] - '0')) % 4 == 0)
			output += i + 1;
	}
	cout << output << "\n";
}
