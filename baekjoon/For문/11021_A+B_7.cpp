#include <iostream>

using namespace std;

int main() {
	/* #11021*/
	int N, A, B;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> A >> B;
		//int sum = A + B;
		cout << "Case #" << i << ": " << A + B << "\n";
	}
}
