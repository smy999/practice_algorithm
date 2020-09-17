// https://programmers.co.kr/learn/courses/30/lessons/12935

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int size = arr.size();
    
    if(size == 1)
        answer.push_back(-1);
    else {
        answer = arr;
        int pos = min_element(answer.begin(), answer.end()) - answer.begin();        
        answer.erase(answer.begin() + pos);
    }
    return answer;
}
