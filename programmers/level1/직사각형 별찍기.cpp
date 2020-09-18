// https://programmers.co.kr/learn/courses/30/lessons/12969

#include <iostream>
using namespace std;

int main(void) {
    int a, b;
    cin >> a >> b;
    
    string star = "";
    
    for(int i = 0; i < a; i++)
        star += '*';

    for(int i = 0; i < b; i++)
        cout << star << "\n";
    
    return 0;
}
