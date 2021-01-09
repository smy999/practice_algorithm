#include <stdio.h>
using namespace std;

/* #11720*/
int main() {
	int size, sum=0;
	scanf("%d", &size);
	
	char* digit = new char[size];
	scanf("%s", digit);

	// ASCII 숫자 N에서 ASCII 숫자 0만큼 빼면 정수 값을 구할 수 있다.
	for (int i = 0; i < size; i++) {
		sum += (digit[i]-'0');
	}
	printf("%d", sum);
}
