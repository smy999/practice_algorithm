// https://programmers.co.kr/learn/courses/30/lessons/12918

function solution(s) {
    var answer = false;
    
    var len = s.length;
    
    if(len == 4 || len == 6) {
        if( isNaN(s)==false){
            answer=true;
        }
    }
    
    return answer;
}
