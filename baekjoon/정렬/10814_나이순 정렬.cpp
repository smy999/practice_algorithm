#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

bool compare(pair <int, string> a, pair <int, string> b) {
	return a.first < b.first;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	vector <pair<int, string>> member;
	int age;
	string name;
	for (int i = 0; i < N; i++) {
		cin >> age >> name;
		member.push_back(make_pair(age, name));
	}

	stable_sort(member.begin(), member.end(), compare);

	for (int i = 0; i < N; i++)
		cout << member[i].first << " " << member[i].second << "\n";

	return 0;
}
