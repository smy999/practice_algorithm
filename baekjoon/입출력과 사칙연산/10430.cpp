#include <iostream> //C++ 표준 입출력 헤더파일

using namespace std;

int main() {
	/* #10430*/
	int A, B, C;
	cin >> A >> B >> C;
	cout << (A + B) % C << "\n";
	cout << (A % C + B % C) % C << "\n";
	cout << (A * B) % C << "\n";
	cout << (A % C * B % C) % C;
}
