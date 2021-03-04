
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_19941_햄버거분배 {
	static int N, K, cnt;
	static char[] table;

	public static void main(String[] args) throws Exception {
		// line: 13~18: 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		table = new char[N];
		table = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++) {
			if(table[i] == 'P') {	// 현재 위치가 사람일 때 탐색
				int j = i-K;		// 현재위치-K
				int j2 = i+K;		// 현재위치+K
				if(j < 0) j = 0;	// 범위 벗어났을 때 왼쪽은 0으로
				if(j2 >= N) j2 = N-1;	// 범위 벗어났을 때 오른쪽은 N-1로 설정
				for(; j <= j2; j++) {	// 현재위치-K ~ 현재위치+K 안에 햄버거가 있으면 가장 왼쪽부터 먹는다.
					if(table[j] == 'H') {
						cnt++;			// 먹은 햄버거 개수 증가
						table[j] = '0';	// 먹은 햄버거 변경
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
