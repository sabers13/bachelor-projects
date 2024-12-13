#include <iostream>
using namespace std;

int main()
{

	int a,b,c,n,i,tmp;
	cin >> n >> a>>b;
	tmp = a;
	if (a > b)
	{
		a = b;
		b = tmp;
	}
	for (i = 3; i <= n; i++)
	{
		cin >> c;
		if (c >= b)
		{
			a = b;
			b = c;
		}

		if (c >= a&&c<b)
				a = c;

	}
	cout << b <<" "<< a;
	cin>>n;
	return 0;
}

