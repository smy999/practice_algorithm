// https://programmers.co.kr/learn/courses/30/lessons/12947

#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int temp = x, digits = 0;
    
    while(temp > 0){
        digits += temp % 10;
        temp /= 10;
    }
    
    if(x % digits == 0) return true;
    else return false;
}
