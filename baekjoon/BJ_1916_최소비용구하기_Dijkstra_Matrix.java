import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1916_최소비용구하기_Matrix {

	static int N, M, start, end;
	static int[][] adjMatrix;
	static int[] dijkstra;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N+1][N+1];
		dijkstra = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(adjMatrix[i], -1);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(adjMatrix[from][to] == -1) adjMatrix[from][to] = cost;
			else if(adjMatrix[from][to] > cost) adjMatrix[from][to] = cost;
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dijkstra, Integer.MAX_VALUE-1);
		
		dijkstra[start] = 0;
		
		for(int i = 0; i < N-1; i++) {
			// 아직 방문하지 않은 경로 중 최소값 찾기
			int min = Integer.MAX_VALUE;
			int from = -1;
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && min > dijkstra[j]) {
					from = j;
					min = dijkstra[j];
				}
			}
			
			visited[from] = true;
			
			for(int to = 1; to <= N; to++) {
				if(!visited[to] && adjMatrix[from][to] != -1 
						&& dijkstra[to] > dijkstra[from] + adjMatrix[from][to]) {
					dijkstra[to] = dijkstra[from] + adjMatrix[from][to];
				}
			}
		}
		System.out.print(dijkstra[end]);
		br.close();
	}
}
