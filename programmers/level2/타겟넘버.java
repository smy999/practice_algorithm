// https://programmers.co.kr/learn/courses/30/lessons/43165

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        int n = numbers.length;
       
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if(cur[1] == n) {
                if (cur[0] == target) answer++;
                continue;
            }
            
            queue.add(new int[] {cur[0]+numbers[cur[1]], cur[1]+1});
            queue.add(new int[] {cur[0]-numbers[cur[1]], cur[1]+1});
        }
    
        return answer;
    }
}
