// https://programmers.co.kr/learn/courses/30/lessons/12915?language=cpp

#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int i;

bool compare(string x, string y){
    return x[i]==y[i]? x<y : x[i]<y[i];
}

vector<string> solution(vector<string> strings, int n) {
    i=n;
    sort(strings.begin(), strings.end(), compare);
    return strings;
}
