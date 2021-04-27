import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치_이분탐색 {

	static int N, C, max = 0;
	static int[] house;
	static int[] wifi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		house = new int[N];
		wifi = new int[C];
		
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
	
		int start = 1;	// 최소거리
		int end = house[N-1] - house[0];	// 최대거리
		int mid = 0;	// 결과
		
		while(start <= end) {
			mid = (start+end)/2;	// 최대 거리와 최소 거리의 중앙값
			int pre = house[0];
			int cnt = 1;
			
			for(int h : house) {
				if(h - pre >= mid) {
					cnt++;
					pre = h;
				}
			}
			
			// 공유기가 모두 설치되었을 때
			if(cnt >= C) start = mid + 1;
			// 설치할 공유기가 남았을 때
			else end = mid - 1;
		}
		
		System.out.print(end);
	}
	
}
