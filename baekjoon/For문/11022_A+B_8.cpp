#include <iostream>

using namespace std;

int main() {
	/* #11022*/
	int A, B, N;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> A >> B;
		cout << "Case #" << i << ": " << A << " + " << B << " = " << A + B << "\n";
	}
}
