// https://programmers.co.kr/learn/courses/30/lessons/12917?language=javascript

function solution(s) {
    var answer = '';
    answer=s.split("");
    answer=answer.sort().reverse();
    return answer.join("");
}
