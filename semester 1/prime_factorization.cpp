#include <iostream>
using namespace std;

int main()
{
	long long number,divisor,divisor_power,i;
	bool divisor_is_prime;
	cin >> number;
	if (number == 1)
		cout << 1;
	for( i=2;i<=number;i++)
		if (number%i == 0)
		{
			divisor = i;
			divisor_power = 0;
			while (number%divisor == 0)
			{
				number = number / divisor;
				divisor_power++;
			}
			if (divisor_power == 1)
				cout << divisor;
			else
				cout << divisor << "^" << divisor_power;
			if (number != 1)
				cout << "*";
		}
	cin >> i;
    return 0;
}
