class Solution {
    
    static int len;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = computers.length;
        
        visited = new boolean[len];
        
        for(int i = 0; i < len; i++) {
            if(visited[i]) continue;
            dfs(computers, i);
            answer++;
        }
        
        return answer;
    }
    
    static public void dfs(int[][] computers, int idx) {
        
        visited[idx] = true;
        
        for(int i = 0; i < len; i++) {
            if(visited[i] || computers[idx][i] == 0) continue;
            dfs(computers, i);
        }
    }
}
