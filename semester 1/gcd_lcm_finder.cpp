#include <iostream>
using namespace std;

int main()
{
	long long x,y,a, b, c;
	cin >> x >> y;
	c = x % y;
	a = x;
	b = y;
	while (c!=0)
	{

		a = b;
		b = c;
		c = a % b;
	}

	cout << b <<" "<< (x/b)*y;
	cin >> a;
    return 0;
}
