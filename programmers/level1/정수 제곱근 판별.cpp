// https://programmers.co.kr/learn/courses/30/lessons/12934

#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    double x = sqrt(n);
    
    cout << x - (int)x;
    
    if (x - (int)x == 0)
        answer = pow(x+1, 2);
    else
       answer = -1; 
    
    return answer;
}
