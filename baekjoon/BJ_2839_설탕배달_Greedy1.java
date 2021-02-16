package workshop;

// 내 풀이: Greedy
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달_Greedy1 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 배달해야하는 설탕 kg
		
		br.close();	// 입력 끝. 스트림 닫기
		
		int bongji = N/5;	// 일단 가능할지도 모르는 봉지의 최소값을 구한다.
		
		while(bongji >= 0) {
			int b = bongji*5;
			
			if(b == N) { // bongji*5가 N과 같으면 반복문 탈출
				break;
			} else if((N - b)%3 == 0) {	// bongji*5를 N에서 뺀 값이 3의 배수면
				bongji += (N - b)/3;	// (뺀 값/3)의 몫을 봉지 개수에 추가한 후
				break;					// 반복문 탈출
			} else {	// 위 두 경우가 모두 아니면 5kg 봉지 수를 하나 줄인 후 다시 반복
				bongji--;
			}
		}
		
		System.out.print(bongji);	// 결과 출력
	}
}
