// https://programmers.co.kr/learn/courses/30/lessons/12903

#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    int len=s.size();
    int middle=len/2;
    
    if(len%2==0){
        answer+=s[middle-1];
        answer+=s[middle];
    }
    else{
        answer+=s[middle];
    }
    
    return answer;
}
