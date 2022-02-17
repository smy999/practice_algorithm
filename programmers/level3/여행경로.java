import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    ArrayList<String> ansList = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        // String[] answer = {};

        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(ansList);
        // answer = ansList.get(0).split(" ");
            
        return ansList.get(0).split(" ");
    }
    
    public void dfs(String from, String path, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            ansList.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(from.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}
