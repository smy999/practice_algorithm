package Oct_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11723_집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int bitset = 0;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String op = st.nextToken();
			int num;
			
			switch(op) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				bitset = bitset | 1<<(num-1);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				sb.append(((bitset & 1<<(num-1)) == 1<<(num-1) ? 1 : 0) + "\n");
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				bitset = bitset & ~(1<<(num-1));
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				bitset = bitset ^ 1<<(num-1);
				break;
			case "all":
				bitset = ~0;
				break;
			case "empty":
				bitset = 0;
				break;
			}
		}
		
		System.out.print(sb);
	}
}
