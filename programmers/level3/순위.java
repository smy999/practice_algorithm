import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = 987654321;
        
        int[][] dist = new int[n+1][n+1];
        for(int[] d : dist) Arrays.fill(d, INF);
        for(int[] r : results) dist[r[0]][r[1]] = 1;
        for(int i = 1; i <= n; i++) dist[i][i] = 0;
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i = 1; i <= n; i++) {
            // int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(dist[i][j] == INF && dist[j][i] == INF) {
                    flag[i] = false;
                    break;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) if(flag[i]) answer++;
        
        return answer;
    }
}
