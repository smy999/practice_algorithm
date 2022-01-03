package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_1292_쉽게푸는문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// 수열 저장 리스트
		ArrayList<Integer> list = new ArrayList<>();
		
		// 수열 안 수의 개수
		int cnt = 0;
		
		// 수열 만들기
		loop: for(int i = 1; i < 200; i++) {
			for(int j = 0; j < i; j++) {
				cnt++;
				list.add(i);
				if(cnt > B) break loop;	// B개보다 많아지면 더이상  구하지 않는다.
			}
		}
		
		// 구간 합 구하기
		int sum = 0;
		for(int i = A-1; i < B; i++) {
			sum += list.get(i);
		}
		
		System.out.print(sum);
	}
}
