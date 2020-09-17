// https://programmers.co.kr/learn/courses/30/lessons/12921

#include <string>
#include <vector>

using namespace std;

int erato[1000000] = {0};

int solution(int n) {
    int answer = 0;

    erato[1]=1; erato[0]=1;
    for(int i=2;i<=1000000;i++){
        if(erato[i]==1){
            continue;
        }
        for(int j=i*2;j<=1000000;j+=i){
            erato[j]=1;
        }
    }
    
    for(int i=2;i<=n;i++){
        if(erato[i]==0)
            answer++;
    }
    
    return answer;
}
