#include <iostream> //C++ 표준 입출력 헤더파일

using namespace std;

int main() {
	/* #2588*/
	int A, B;
	cin >> A;
	cin >> B;
	cout << A * (B % 10) << "\n";
	cout << A * ((B / 10) % 10) << "\n";
	cout << A * (B / 100) << "\n";
	cout << A * B;
}
