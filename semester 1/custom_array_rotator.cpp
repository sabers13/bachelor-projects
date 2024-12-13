#include <iostream>
using namespace std;

int main()
{
	int temp,n[10], i,a,b,j;
	cin >> a >> b;
	for (i = 0; i <= 9; i++)
		cin >> n[i];
	b = b % 10;
	for (j = 0; j < b; j++)
	{

		for (i = 0; i <= 8; i++)
		{

			temp = n[i + 1];
			n[i + 1] = n[a*i];
			n[a*i] = temp;
		}

	}
	for(i=0;i<10;i++)
	    cout << n[i]<<" ";
	cin >> i;
    return 0;
}
