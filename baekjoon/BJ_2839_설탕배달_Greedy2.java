package workshop;

// 교수님 풀이: Greedy

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달_Greedy2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 배달해야하는 설탕 kg
		
		br.close();	// 입력 끝. 스트림 닫기
		
		int bongji = 0;	// 봉지 개수
		
		while(true) {
			if(N < 0) {
				System.out.println(-1);
				break;
			}
			
			if(N%5 == 0) {
				System.out.println(N/5 + bongji);
			}else {
				N = N - 3;
				bongji++;
			}
		}
		
		System.out.print(bongji);
	}
}
