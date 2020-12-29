#include <iostream>

using namespace std;

int main() {
	/* #15552*/
	int N, A, B;
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> A >> B;
		cout << A + B << "\n";
	}
}
