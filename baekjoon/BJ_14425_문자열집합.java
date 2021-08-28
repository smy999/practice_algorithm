package Sep_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

// 배열: 보통(equals)
// hashset: 가능(contains)
// hashmap: 빠름(get)

public class BJ_14425_문자열집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(map.get(str) != null) {
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
}
