#include <iostream>
using namespace std;

int main(void) {
	/* #1110*/
	int N1, N2, temp, count = 0;
	cin >> N1;
	N2 = N1;
	while (true) {
		temp = (N2 / 10) + (N2 % 10);
		N2 = (N2 % 10) * 10 + (temp % 10);
		count++;
		if (N1 == N2) {
			break;
		}
	}
	cout << count;
}

