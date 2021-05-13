import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_5014_스타트링크 {

	//  전체 층 수, 강호 위치, 스타트링크 위치, 버튼업, 버튼다운
	static int F, S, G, U, D, cnt = 0;
	static boolean canGo = false;
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[][] visited;
	static class Info{
		int floor, button;
		public Info(int floor, int button) {
			this.floor = floor;
			this.button = button;	// U: 0, D: 1
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1][2];
		
		queue.add(G);
		visited[G][0] = true;
		visited[G][1] = true;
		
		bfs();
		
		if(canGo) System.out.print(cnt);
		else System.out.print("use the stairs");
	}
	
	private static void bfs() {
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == S) {
				canGo = true;
				break;
			}
			
			cnt++;	// queue에서 하나씩 꺼낼 때마다 이동
			
			int nf = cur + U; // 위로 움직일 때
			if(nf >= 1 && nf <= F && !visited[nf][0]) {
				visited[nf][0] = true;
				queue.offer(nf);
				continue;	// 2번 들어가는 것을 방지하기 위해 continue
			}
			
			nf = cur - D; // 아래로 움직일 때
			if(nf >= 1 && nf <= F && !visited[nf][1]) {
				visited[nf][1] = true;
				queue.offer(nf);
			}
		}
	}
}
