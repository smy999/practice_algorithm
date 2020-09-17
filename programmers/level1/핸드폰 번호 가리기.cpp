// https://programmers.co.kr/learn/courses/30/lessons/12948

#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = phone_number;
    int size = answer.size();
    
    for(int i = 0; i < size - 4; i++){
        answer[i] = '*';
    }
    
    return answer;
}
