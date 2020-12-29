#include <iostream>

using namespace std;

int main() {
	/* #10952*/
	int A, B, flag = 1;
	while (flag != 0) {
		cin >> A >> B;
		if (A == 0 && B == 0) {
			flag = 0;
			break;
		}
		cout << A + B << "\n";
	}
}

