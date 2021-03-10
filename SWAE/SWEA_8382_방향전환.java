import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {

	static int x1, x2, y1, y2, cnt, min;
	static boolean flag;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			cnt = 0;
			min = 0;

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int tx = x1, ty = y1;
			flag = false;
			while (true) {
				if (tx == x2 && ty == y2)
					break;
				cnt++;
				if (flag) {
					if (tx < x2) tx++;
					else tx--;
					flag = false;
				} else {
					if (ty < y2) ty++;
					else ty--;
					flag = true;
				}
			}

			min = cnt;
			cnt = 0;

			tx = x1; ty = y1;
			flag = true;
			while (true) {
				if (tx == x2 && ty == y2) break;
				cnt++;
				if (flag) {
					if (tx < x2) tx++;
					else tx--;
					flag = false;
				} else {
					if (ty < y2) ty++;
					else ty--;
					flag = true;
				}
			}

			min = Math.min(min, cnt);

			sb.append(min + "\n");
		}

		System.out.print(sb);
	}
}
