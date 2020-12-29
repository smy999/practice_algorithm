#include <vector>
using namespace std;

long long sum(vector<int>& a) {
	long long sum=0;
	for (vector<int>::iterator i = a.begin(); i != a.end(); i++) {
		sum += *i;
	}
	return sum;
}
