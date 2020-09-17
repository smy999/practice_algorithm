// https://programmers.co.kr/learn/courses/30/lessons/12933

#include <string>
#include <vector>
#include <algorithm>
#include <functional>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    string s = to_string(n);
    
    sort(s.begin(), s.end(), greater<int>());
    
    answer = stoll(s);
    
    return answer;
}
