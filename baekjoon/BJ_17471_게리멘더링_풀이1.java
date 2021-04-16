package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_17471_게리멘더링_sol {

	static int N, min = Integer.MAX_VALUE;
	static int[][] matrix;
	static boolean[] select;	// for subset
	static boolean[] visited;	// for connection check
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N+1][N+1];
		select = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// subset
		subset(1);
		
		if(min == Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(min);
	}
	
	private static void subset(int srcIdx) {
		// 기저 조건
		if(srcIdx == N+1) {
			// complete code
			check();
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx+1);
		select[srcIdx] = false;
		subset(srcIdx+1);
	}
	
	private static void check() {
		// visited 이용
		// A, B 두 개의 부분집합을 select로 구분한다.
		// 각각 bfs(matrix)를 돌린다. 이때 방문하면 visited에 방문 표시
		
		visited = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		
		// A
		for(int i = 1; i <= N; i++) {
			if(select[i]) {
				queue.add(i);
				break;
			}
		}
		
		if(queue.size() == 0 || queue.size() == N) return;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			visited[n] = true;
			
			for(int i = 1; i <= N; i++) {
				int adj = matrix[n][i];
				if(adj == 0 || visited[adj] || !select[adj]) continue;
				
				queue.add(adj);
			}
		}
		
		// B
		for(int i = 1; i <= N; i++) {
			if(!select[i]) {
				queue.add(i);
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			visited[n] = true;
			
			for(int i = 1; i <= N; i++) {
				int adj = matrix[n][i];
				if(adj == 0 || visited[adj] || select[adj]) continue;
				
				queue.add(adj);
			}
		}
		
		boolean allVisited = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				allVisited = false;
				break;
			}
		}
		
		if(allVisited) {
			int sumA = 0;
			int sumB = 0;
			for(int i = 1; i <= N; i++) {
				if(select[i]) sumA += matrix[i][0];
				else sumB+= matrix[i][0];
			}
			
			min = Math.min(min, Math.abs(sumA-sumB));
		}
	}
}

