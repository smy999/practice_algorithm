#include <iostream>
using namespace std;

int factorial(int N) {
	if (N == 0) 
        return 1;
	else 
        return N * factorial(N - 1);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	cout << factorial(N);
}
