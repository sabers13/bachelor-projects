#include <iostream>
using namespace std;

int main()
{
	int j, i, max, maxIndex, items[100];
	for (j = 0; j <= 99; j++)
		cin >> items[j];
	for (j = 0; j <= 98; j++)
	{
		max = items[j];
		maxIndex = j;
			for(i=j+1;i<=99;i++)
				if (max < items[i])
				{
					max = items[i];
					maxIndex = i;
				}
			items[maxIndex] = items[j];
			items[j] = max;
	}
	for (i = 0; i<100; i++)
		cout << items[i] << " ";
	cin >> i;
    return 0;
}
