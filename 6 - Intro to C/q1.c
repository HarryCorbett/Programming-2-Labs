
#include <stdio.h>
#include <math.h>

int CACHE(double* prod, double* sum, double d1, double d2) {

	int num1, num2;
	num1 = floor(d1);
	num2 = floor(d2);

	int product = num1 * num2;
	int summ = num1 + num2;

	*prod = product;
	*sum = summ;

	if ( (num1 < 0 && num2 < 0) || (num1 > 0 && num2 > 0) || (num1 == 0 && num2 == 0)) {
		return 1;
	}
	else {
		return -1;
	}

}

int main(void) {

	int VAR, x;
	for (x = 0; x < 3;x++)
	{
		VAR = x * 10;;
		if (VAR = 10)
		{
			printf("ABC\n");
		}
		else
		{
			printf("XYZ\n");
		}
	}

}
