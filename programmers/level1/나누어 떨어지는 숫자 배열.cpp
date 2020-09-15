// https://programmers.co.kr/learn/courses/30/lessons/12910

#include <string>
#include <vector>
#include <algorithm>        // 정렬 함수를 사용하기 위한 algorithm 헤더

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    
    vector<int> answer;                 // 결과 벡터
    
    int size1 = arr.size();                 // 입력 벡터 arr 크기
    
    for(int i = 0; i < size1; i++)
        if(arr[i] % divisor == 0)
            answer.push_back(arr[i]);

    int size = answer.size();           // 결과 벡터 answer 크기
    
    if(size == 0)                               // 나누어 떨어지는 원소가 없다면 -1 할당
        answer.push_back(-1);
    else                                            // 따로 구현하지 않고 sort 함수를 사용하여 간단하게 구현
        sort(answer.begin(), answer.begin()+size);
    
    return answer;
}
