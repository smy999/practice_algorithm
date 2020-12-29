#include <iostream>

using namespace std;

int main() {
	/* #8393*/
	int N, sum = 0;
	cin >> N;
	for (int i = 0; i <= N; i++) {
		sum = sum + i;
	}
	cout << sum;
}
