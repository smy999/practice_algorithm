// https://programmers.co.kr/learn/courses/30/lessons/12931

#include <iostream>

using namespace std;
int solution(int n)
{
    int answer = 0;

    string s = to_string(n);
    
    for(int i = 0; i < s.size(); i++){
        answer += s[i] - '0';
    }

    return answer;
}
