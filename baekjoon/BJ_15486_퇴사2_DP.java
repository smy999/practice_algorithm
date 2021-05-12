import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		int[] DP = new int[N+2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N; i > 0; i--) {
			// 오류: DP[i] = DP[N+1]가 아니라 DP[i+1]
			if(i+T[i] > N+1) DP[i] = DP[i+1];
			else {
				int dpVal = DP[i+T[i]] + P[i];
				DP[i] = dpVal > DP[i+1] ? dpVal : DP[i+1];
			}
		}
		System.out.print(DP[1]);
	}
}
