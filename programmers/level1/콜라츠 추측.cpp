// https://programmers.co.kr/learn/courses/30/lessons/12943

#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    
    while(answer <= 500){
        if (num % 2 == 0) num /= 2;
        else num = (num * 3) + 1;
        
        answer++;

        if(num == 1)  break;
    }
    if( answer > 500) return -1;
    return answer;
}
