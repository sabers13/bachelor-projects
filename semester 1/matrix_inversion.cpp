#include <iostream>
using namespace std;

int main()
{
	int a[3][3], i, j;
	float determinant = 0,n;

	for (i = 0; i<3; i++)
		for (j = 0; j<3; j++)
			cin>> a[i][j];

	for (i = 0; i<3; i++)
		determinant = determinant + (a[0][i] * (a[1][(i + 1) % 3] * a[2][(i + 2) % 3] - a[1][(i + 2) % 3] * a[2][(i + 1) % 3]));
	if (determinant)
	{
		for (j = 0; j < 3; j++)
		{
			for (i = 0; i < 3; i++)
			{
				n = ((a[(i + 1) % 3][(j + 1) % 3] * a[(i + 2) % 3][(j + 2) % 3]) - (a[(i + 1) % 3][(j + 2) % 3] * a[(i + 2) % 3][(j + 1) % 3])) / determinant;
				if (n == -0)
					cout << 0 << "\t";
				else
					cout << n << "\t";
			}
			cout << "\n";
		}
	}
	else
		cout << "ERROR";
	return 0;
}
