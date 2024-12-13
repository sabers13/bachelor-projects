#include <iostream>
using namespace std;

int main()
{

	long long n,m,i,j,s,sum;
	s = 0;
	sum = 0;
	cin >> n >> m;
	for (i = -10; i <= m; i++)
	{
		for (j = 1; j <= n; j++)
		{
			s = s + ((i + j)*(i + j)*(i + j)) / (j * j);
		}
	sum = sum + s;
	s = 0;
	}
	cout << sum;
	cin>>n;
	return 0;
}

