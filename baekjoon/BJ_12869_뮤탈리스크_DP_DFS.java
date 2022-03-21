package Mar_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12869_뮤탈리스크_DP_DFS {

	static int[][][] DP = new int[61][61][61];
	static int[] px = {1,1,3,3,9,9};
	static int[] py = {3,9,1,9,1,3};
	static int[] pz = {9,3,9,1,3,1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] SCV = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) SCV[i] = Integer.parseInt(st.nextToken());
		
		dfs(SCV[0], SCV[1], SCV[2], 0);
		
		System.out.print(min);
	}
	
	public static void dfs(int x, int y, int z, int cnt) {
		// backtracking: 이미 구해진 수 보다 cnt가 크다면 구할 필요가 없다.
		if(DP[x][y][z] <= cnt && DP[x][y][z] != 0) return;
		
		// 모두 파괴되었을 경우에서 최소 횟수를 구한다.
		if(x  == 0 && y == 0 && z == 0) {
			min = Math.min(min, cnt);
			return;
		}
		
		// SCV가 각각 x, y, z일 때 공격 횟수를 저장
		DP[x][y][z] = cnt;
		
		int nx = 0, ny = 0, nz = 0;
		for(int i = 0; i < 6; i++) {	// 첫 번째에서 세 번째까지 가능한 조합은 6가지(px, py, pz) 
			// 다음 탐색 위치 정하
			nx = x - px[i]; ny = y - py[i]; nz = z - pz[i];
			// 체력이 0 미만일 경우 파괴된 것으로 간주해 0으로 변경
			nx = nx < 0 ? 0 : nx; ny = ny < 0 ? 0 : ny; nz = nz < 0 ? 0 : nz;
			// 다음 경우 판단
			dfs(nx, ny, nz, cnt+1);
		}
	}
}
