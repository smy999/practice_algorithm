import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int max = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        bfs();
        
        for(int d : dist) {
            if(d == max) answer++;
        }
        
        return answer;
    }
    
    static public void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
                     
            for(int i = 0; i < graph[cur[0]].size(); i++) {
                int next = graph[cur[0]].get(i);
                
                if(visited[next]) continue;
                
                visited[next] = true;
                queue.add(new int[] {next, cur[1]+1});
                
                dist[next] = cur[1]+1;
                max = Math.max(max, cur[1]+1);
            }
        }
    }
}
