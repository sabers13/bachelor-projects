
#include <iostream>
using namespace std;

int main()
{
	int temp, n[100], i, b, j;
	cin  >> b;
	for (i = 0; i <= 99; i++)
		cin >> n[i];
	b = b % 100;
	for (j = 0; j < b; j++)
	{

		for (i = 0; i <= 98; i++)
		{

			temp = n[i + 1];
			n[i + 1] = n[0];
			n[0] = temp;
		}

	}
	for (i = 0; i < 100; i++)
	{
		cout << n[i] << " ";
		if ((i + 1) % 10 == 0)
		{
			cout<<"\n";
		}
	}
	cin >> i;
	return 0;
}
