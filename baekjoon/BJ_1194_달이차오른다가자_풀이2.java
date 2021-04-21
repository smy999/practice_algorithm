package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1194_달이차오른다가자_풀이2 {

	static int N, M, startR, startC, result;
	static char[][] map; 
	static boolean[][][] visited;
	static Queue<Node> queue = new LinkedList<Node>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node {
		int y, x, key, d;
		public Node(int y, int x, int key, int d) {
			this.y = y;
			this.x = x;
			this.key = key;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];	// shift 연산 (0000 00001 > 0100 0000)
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					queue.add(new Node(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}
		
		result = bfs();
		System.out.print(result);
	}
	
	private static int bfs() {

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(map[node.y][node.x] == '1') return node.d;
			
			for(int d = 0; d < 4; d++) {
				int nr = node.y + dr[d];
				int nc = node.x + dc[d];
				int key = node.key;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') continue;

				int cell = map[nr][nc];
				
				if(cell >= 65 && cell <= 90) {	// 문(열쇠를 포함하지 않을 때)
					if((key & (1 << (cell - 65))) == 0)	// & 연산 > 포함되는지 확인
						continue;
				}
				
				if(cell >= 97 && cell <= 112) {	// key
					key |= (1 << (cell - 97));	// or 연산 > 추가되는 개념
				}
				
				if(visited[nr][nc][key]) continue;	// 방문확인
				
				visited[nr][nc][key] = true;
				queue.add(new Node(nr, nc, key, node.d+1));
				
			}
		}
		
		return -1;
	}
}
