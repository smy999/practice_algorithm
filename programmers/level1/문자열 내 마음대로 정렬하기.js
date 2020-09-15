// https://programmers.co.kr/learn/courses/30/lessons/12915

function solution(strings, n) {
    
    return strings.sort((x, y) => {
        if(x[n] > y[n]) return 1;
        if(x[n] < y[n]) return -1;

        if(x > y) return 1;
        if(x < y) return -1;

        return 0;
    });
}
