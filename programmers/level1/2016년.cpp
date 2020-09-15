// https://programmers.co.kr/learn/courses/30/lessons/12901

#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    
    vector<string> weekDay={"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    vector<int> monthDay={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    int year=2016;  // 주어진 년도
    int last=year-1;    // 주어진 년도의 전년도
    int leap = (last/4) - (last/100) + (last/400);      //  1년 ~ 2015년까지 윤년의 수
    int days = ((last*365)+leap);                               // 1년 ~2015년까지 총 일자 수
    
    // 해당 년도(2016)이 윤년이면 2월의 일자수를 29로 변경
    if((year%4==0&&year%100!=0)||year%400==0){
        monthDay.erase(monthDay.begin()+1);
        monthDay.insert(monthDay.begin()+1, 29);
    }
    
    // 전년도까지의 종 일자 수 + 주어진 달의 전달(a-1)까지의 일자
    for(int i=0;i<a-1;i++){
        days+=monthDay[i];
    }
    
    // 주어진 달의 주어진 일자 더한다.
    days+=b;
    
    // 총 일자수를 7로 나눈 나머지
    days%=7;
    
    // 나머지에 따라 해당 요일을 answer에 저장
    for(int i=0;i<7;i++){
        if(days==i){
            answer=weekDay[i];
            break;
        }
    }
    
    return answer;
}
