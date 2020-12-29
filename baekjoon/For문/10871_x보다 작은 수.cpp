#include <iostream>

using namespace std;

int main() {
	/* #10871*/
	int N, X, seq;
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N >> X;
	for (int i = 1; i <= N; i++) {
		cin >> seq;
		if (seq < X) {
			cout << seq << " ";
		}
	}
}
