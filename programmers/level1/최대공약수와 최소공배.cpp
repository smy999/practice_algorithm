// https://programmers.co.kr/learn/courses/30/lessons/12940

#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    int min, max, rem;
    
    if (n < m) {
        min = n; max = m;
    }
    else {
        min = m; max = n;
    }
    
    while(true) {
        rem = max % min;
        if(rem == 0){
            answer.push_back(min);
            break;
        }
        max = min;
        min = rem;
    }

    answer.push_back((n * m) / answer[0]);
    
    return answer;
}
