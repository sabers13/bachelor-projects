#include <iostream>
using namespace std;

int main()
{
	int n, s,tmp,a,nontrivial,i,j,prime;
	cin >> n;
	tmp = n;
	s = 0;
	while (tmp / 10)
	{
		s = s + (tmp % 10);
		tmp = tmp / 10;

	}
	a = s + tmp;
	i = n;
	nontrivial = 0;
	prime = 0;
	while (prime!=a)
	{

		i++;
		{
			for (j = 2; j < i; j++)
			{
				if (i%j == 0)
				{
					nontrivial = 1;
					break;
				}
			}
			if (!nontrivial)
				prime++;
		}
				nontrivial = 0;

	}
	cout << i;
	cin >> s;
    return 0;
}

