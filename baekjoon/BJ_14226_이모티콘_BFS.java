package Feb_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_14226_이모티콘_BFS {

	static class Emoji {
		int cnt, time, clip;
		public Emoji(int cnt, int time, int clip) {
			this.cnt = cnt; this.time = time; this.clip = clip;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		
		boolean[][] visited = new boolean[1001][1001];
		Queue<Emoji> queue = new LinkedList<>();
		
		// 이미 화면에 이모티콘 1개를 입력
		queue.add(new Emoji(1, 0, 0));
		
		while(!queue.isEmpty()) {
			Emoji e = queue.poll();
			
			if(e.cnt == S) {
				System.out.print(e.time);
				break;
			}
			
			visited[e.cnt][e.clip] = true;
			
			// 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			queue.add(new Emoji(e.cnt, e.time+1, e.cnt));
			
			// 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
			int next = e.cnt + e.clip;
			if(e.clip != 0 && next <= 1000 && !visited[next][e.clip]) {
				queue.add(new Emoji(next, e.time+1, e.clip));	// 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없다.
				visited[next][e.clip] = true;
			}
			
			// 화면에 있는 이모티콘 중 하나를 삭제한다.
			next = e.cnt - 1;
			if(next >= 2 && !visited[next][e.clip]) {
				queue.add(new Emoji(next, e.time+1, e.clip));
				visited[next][e.clip] = true;
			}
		}
	}
}
