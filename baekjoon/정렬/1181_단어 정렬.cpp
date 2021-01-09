#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;


bool compare(string a, string b) {
	if (a.size() == b.size())
		return a < b;
	else
		return a.size() < b.size();
}

int main() {
	// reduce I/O time
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	string temp;
	vector <string> word;

	for (int i = 0; i < N; i++) {
		cin >> temp;
		if(find(word.begin(), word.end(), temp) == word.end())
			word.push_back(temp);
	}

	sort(word.begin(), word.end(), compare);

	for (int i = 0; i < word.size(); i++) 
		cout << word[i] << "\n";

	return 0;
}
