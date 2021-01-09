#include <iostream>
#include <stdio.h>
using namespace std;


/* #1436*/
/**/
int main() {
	int series=666, temp, flag;

	int N;
	scanf("%d", &N);

	while (N > 0) {
		temp = series;
		flag = 0;
		
		while (temp > 0) {
			if (temp % 1000 == 666) {
				flag = 1;
				break;
			}
			else
				flag = 0;
			
			temp /= 10;
		}

		if (flag == 1)
			N--;
		
		series++;
	}

	printf("%d", series-1);
}
