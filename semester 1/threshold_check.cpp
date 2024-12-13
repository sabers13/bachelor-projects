#include <iostream>
using namespace std;

int main()
{
int n, k, i,m,s;
	cin >> n >> k;
	s = 0;
	for (i = 1; i <= n; i++)
	{
		cin >> m;
		if (m <= 0)
			s++;
	}
	if (s >= k)
		cout << "YES";
	else
		cout << "NO";
	cin>>n;
	return 0;
}

