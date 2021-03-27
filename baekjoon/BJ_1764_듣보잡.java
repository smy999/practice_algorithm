
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_1764_듣보잡 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] deudjab = new String[N];
		String bojab = "";
		
		for(int i = 0; i < N; i++) {
			deudjab[i] = br.readLine();
		}
		
		Arrays.sort(deudjab);
		
		ArrayList<String> deudbo = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			bojab = br.readLine();
			int same = Arrays.binarySearch(deudjab, bojab);
			if(same >= 0) deudbo.add(bojab);
		}
		
		Collections.sort(deudbo);
		StringBuilder sb = new StringBuilder();
		
		int cnt = deudbo.size();
		for(int i = 0; i < cnt; i++) sb.append(deudbo.get(i) + "\n"); 
		
		System.out.print(cnt + "\n" + sb);
	}
}


/*
 * 시간 초과 코드

		Arrays.sort(deudjab);
		Arrays.sort(bojab);
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		for(int i = 0; i < N;) {
			for(int j = 0; j < M;) {
				int result = deudjab[i].compareTo(bojab[j]);
				if(result == 0) {
					sb.append(deudjab[i] + "\n");
					cnt++;
					i++; j++;
				} else if(result < 0) {
					i++;
				} else {
					j++;
				}
			}
		}
		
 * 
 */
