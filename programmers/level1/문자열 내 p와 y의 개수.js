// https://programmers.co.kr/learn/courses/30/lessons/12916

function solution(s){

    var numP = s.match(/p/ig);
    var numY = s.match(/y/ig);
    
    if(numP.length==numY.length || (numP.length==0 && numY.length==0))
        return true;
    else
        return false;

}
