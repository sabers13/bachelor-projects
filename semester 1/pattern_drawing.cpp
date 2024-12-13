#include <iostream>
using namespace std;

int main()
{

	int n,i,j;
	cin >> n;
	for (i = 1; i <= n; i++)
	{
		cout << "#";
		for (j = 1; j < n; j++)
		{
			if ( j == n-1 || j == i-1 || (j >= (n - i)&&(j>=i||i+j==n))  ||i==n||i==1)
				cout << "#";
			else
				cout << " ";
		}
		cout << "\n";
	}
	cin>>n;
	return 0;
}

