// https://programmers.co.kr/learn/courses/30/lessons/12930

#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int count = 0;
    
    for(int i=0;i<s.size();i++){
        if(s[i] == 32){
            answer += s[i];
            count = 0;
            continue;
        }
        else if (count == 0 || count % 2 == 0)
            answer += toupper(s[i]);
        else
            answer += tolower(s[i]);
        
        count++;
    }
    
    return answer;
}
