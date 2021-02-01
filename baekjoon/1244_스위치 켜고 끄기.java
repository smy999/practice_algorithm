package hwalgo01;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244 {

	static int S, N, gender, num;
	static char[] tmp;
	static int[] switchArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());				// 스위치의 개수 입력
		switchArr = new int[S];			// 스위치 개수만큼의 크기를 갖는 배열 생성 후 스위치 상태 저장

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < S; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}

		N = Integer.parseInt(br.readLine());				// 학생 수 입력 후 학생 수만큼 반복하며 스위치 상태 변경
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st2.nextToken());
			num = Integer.parseInt(st2.nextToken());

			if(gender == 1) {	// 남학생
				for(int j = num-1; j < S; j+=num) {
					if(switchArr[j] == 1) switchArr[j] = 0;
					else switchArr[j] = 1;
				}
			} 
			else {	// 여학생	
				
				if(switchArr[num-1] == 1) switchArr[num-1] = 0;	// 받은 수에 위치하는 요소 변겅
				else switchArr[num-1] = 1;

				for(int d = 1; d < num; d++) {	// 받은 수의 양쪽을 비교한다.
					int dx = (num-1) + d*(-1);
					int dy = (num-1) + d;

					if(dx >= 0 && dy < S && switchArr[dx] == switchArr[dy]) {
						if(switchArr[dx] == 1) {
							switchArr[dx] = 0; switchArr[dy] = 0;
						} else {
							switchArr[dx] = 1; switchArr[dy] = 1;
						}
					}
					else break;
				}
			}
		}
		for(int i = 0; i < S; i++) {
			System.out.print(switchArr[i] + " ");
            if((i+1)%20 == 0) System.out.println();
		}
	}
}
