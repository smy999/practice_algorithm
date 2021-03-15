import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_8382_방향전환 {

	static int r1, r2, c1, c2, max;
	static boolean[][][] visited;
	static Queue<Point> queue;
	
	// delta: 상하우좌
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	
	static class Point {
		int r;
		int c;
		int cnt;
		boolean d;	// 상하:true, 좌우:false
		public Point(int r, int c, boolean d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public boolean equals(Object obj) {
			Point p = (Point)obj;
			return this.r == p.r && this.c == p.c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			st = new StringTokenizer(br.readLine());
			r1 = Integer.parseInt(st.nextToken())+100;
			c1 = Integer.parseInt(st.nextToken())+100;
			r2 = Integer.parseInt(st.nextToken())+100;
			c2 = Integer.parseInt(st.nextToken())+100;
			
			queue = new LinkedList<>();
			queue.add(new Point(r1, c1, false));
			queue.add(new Point(r1, c1, true));
			Point dest = new Point(r2, c2, false);
			
			visited = new boolean[201][201][2];
			visited[r1][c1][0] = true;
			visited[r1][c1][1] = true;
			
			max = 0;
			
			while(!queue.isEmpty()) {
				// 하나씩 꺼내기
				Point p = queue.poll();
				// 이동 칸 수 갱신
				max = Math.max(max,  p.cnt);
				// queue에서 꺼낸 Point 정보가 도착지 정보와 같으면 탐색 종료 
				if(p.equals(dest)) break;
				
				// 방향: 상하
				if(p.d) {
					for(int d = 0; d < 2; d++) {
						int nr = p.r + dr[d];
						int nc = p.c + dc[d];
						
						if(nr < 0 || nr >= 201 || nc < 0 || nc >= 201 || visited[nr][nc][0]) continue;
						
						Point nextP = new Point(nr, nc, !p.d);
						nextP.cnt = p.cnt+1;
						queue.add(nextP);
						visited[nr][nc][0] = true;
					}
				} // 반향: 좌우
				else {
					for(int d = 2; d < 4; d++) {
						int nr = p.r + dr[d];
						int nc = p.c + dc[d];
						
						if(nr < 0 || nr >= 201 || nc < 0 || nc >= 201 || visited[nr][nc][1]) continue;
						
						Point nextP = new Point(nr, nc, !p.d);
						nextP.cnt = p.cnt+1;
						queue.add(nextP);
						visited[nr][nc][1] = true;
					}
				}
			}

			sb.append(max + "\n");	// 출력 문자열에 결과 저장
		}

		System.out.print(sb);	// 결과 출력
	}
}
