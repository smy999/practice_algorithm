 package July_week3;

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.util.StringTokenizer;
 
public class BJ_1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] seq = new int[N];
		for(int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		int[] DP = new int[N];
		DP[0] = seq[0];
		int max = DP[0];
		for(int i = 1; i < N; i++) {
			DP[i] = Math.max(seq[i], DP[i-1]+seq[i]);
			max = Math.max(max, DP[i]);	// 오류 원인: DP 배열만 채우고 중간 max 갱신을 안해줌
		}
		
		System.out.print(max);
	}
}
