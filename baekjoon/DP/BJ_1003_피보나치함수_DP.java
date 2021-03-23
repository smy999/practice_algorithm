import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1003_피보나치함수 {

	static int N;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			
			D = new int[N + 1][2];
			if(N < 2) D = new int[2][2];
			
			D[0][0] = 1; D[0][1] = 0;
			D[1][0] = 0; D[1][1] = 1;

			if (N >= 2) {
				for (int i = 2; i <= N; i++) {
					D[i][0] = D[i - 2][0] + D[i - 1][0];
					D[i][1] = D[i - 2][1] + D[i - 1][1];
				}
			}

			sb.append(D[N][0] + " " + D[N][1] + "\n");
		}
		System.out.print(sb);
	}
}
