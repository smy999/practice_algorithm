#include <stdio.h>
#include <string.h>
#include <iostream>
//#include <string>	// getline() 헤더
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, count=0;
	string words;
	
	cin >> N;

	for (int i = 0; i<N; i++) {

		cin >> words;
		int len = words.length(), j;
		
		if (len == 1 || len == 2)
			count ++;
		else {
			
			count++;
			
			for (j = 0; j < len-2; j++) {
				
				if ((words[j] != words[j + 1]) && ((int)words.find(words[j], j + 2)) > j + 1) {
					count--;
					break;
				}
			}
		}
	}
	cout << count;
}
