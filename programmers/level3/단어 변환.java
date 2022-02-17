import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static class Word {
        String w; int cnt;
        public Word(String w, int cnt) {
            this.w = w; this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        boolean[] visited = new boolean[len];
        
        while(!queue.isEmpty()) {
            Word cur = queue.poll();

            if(cur.w.equals(target)) {
                answer = cur.cnt;
                break;
            }
            
            for(int i = 0; i < len; i++) {
                if(visited[i]) continue;
                
                int missCnt = 0;
                for(int j = 0; j < words[i].length(); j++) {
                    if(cur.w.charAt(j) != words[i].charAt(j)) missCnt++;
                    if(missCnt > 1) break;
                }
                
                if(missCnt > 1) continue;
                
                queue.add(new Word(words[i], cur.cnt+1));
                visited[i] = true;
            }
        }
        
        return answer;
    }
}
