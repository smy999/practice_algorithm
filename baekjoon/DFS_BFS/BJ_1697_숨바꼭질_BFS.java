import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1697_숨바꼭질 {

	// K와 N의 범위는 1~100000
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		// line 21~38: bfs
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			int n = q[0];
			int cnt = q[1];
			
			if(n == K) {
				ans = cnt;
				break;
			}
			
			if(check(n-1)) queue.add(new int[] {n-1, cnt+1});
			if(check(n+1)) queue.add(new int[] {n+1, cnt+1});
			if(check(n*2)) queue.add(new int[] {n*2, cnt+1});
		}
		
		System.out.print(ans);
	}
	
	/* 범위 검사 */
	private static boolean check(int n) {
		if(n < 0 || n > 100000 || visited[n]) return false;
		visited[n] = true;
		return true;
	}
}
