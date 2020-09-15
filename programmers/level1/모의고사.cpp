// https://programmers.co.kr/learn/courses/30/lessons/42840

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> num1 = {1,2,3,4,5};
vector<int> num2 = {2,1,2,3,2,4,2,5};
vector<int> num3 = {3,3,1,1,2,2,4,4,5,5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> count(3);
    
    // 맞은 개수를 count에 저장
    for(int i=0; i<answers.size(); i++) {
        if(answers[i] == num1[i%5]) 
            count[0]++;
        if(answers[i] == num2[i%8]) 
            count[1]++;
        if(answers[i] == num3[i%10]) 
            count[2]++;
    }
    
    int max = *max_element(count.begin(), count.end());
    for(int i = 0; i< 3; i++) {
        if(count[i] == max)
            answer.push_back(i+1);
    }
    
    return answer;
}
