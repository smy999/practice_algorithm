import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환_규칙 {

	static int x1, x2, y1, y2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int x = Math.abs(x1-x2);
			int y = Math.abs(y1-y2);
			
			int longN = Math.max(x,  y);
			int shortN = Math.min(x,  y);

			sb.append((shortN*2 + (longN-shortN)*2 - ((longN-shortN)%2)) + "\n");	// 출력 문자열에 결과 저장
		}

		System.out.print(sb);	// 결과 출력
	}
}
