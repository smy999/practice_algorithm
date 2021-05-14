import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_5014_스타트링크 {

	//  전체 층 수, 강호 위치, 스타트링크 위치, 버튼업, 버튼다운
	static int F, S, G, U, D, cnt = Integer.MAX_VALUE;
	static boolean canGo = false;
	static Queue<Info> queue = new LinkedList<>();
	static boolean[][] visited;
	static class Info{
		int floor, move;
		public Info(int floor, int move) {
			this.floor = floor;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1][2];
		
		// 출발: S
		queue.add(new Info(S, 0));
		visited[S][0] = true;
		visited[S][1] = true;
		
		bfs();
		
		if(canGo) System.out.print(cnt);
		else System.out.print("use the stairs");
	}
	
	private static void bfs() {
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			int floor = info.floor;
			int move = info.move;
			
			// 도착: G
			if(floor == G) {
				canGo = true;
				cnt = move;
				break;
			}
			
			// 위로 움직일 때
			int nf = floor + U; 
			if(nf >= 1 && nf <= F && !visited[nf][0]) { 	// 범위 안에 있고, 해당 방향으로 방문한 적이 없을 때
				visited[nf][0] = true;
				queue.offer(new Info(nf, move+1));
			}
			
			// 아래로 움직일 때
			nf = floor - D; 
			if(nf >= 1 && nf <= F && !visited[nf][1]){
				visited[nf][1] = true;
				queue.offer(new Info(nf, move+1));
			}
		}
	}
}
