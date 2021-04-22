import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BJ_18870_좌표압축_이분탐색 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] pos = new int[N];	// 초기 배열
		int[] sort = new int[N];// 정렬 배열
		int[] map = new int[N];	// 정렬 & 중복제거 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pos[i] = num;
			sort[i] = num;
		}

		Arrays.sort(sort);
		
		map[0] = sort[0];
		int end = 0;
		for(int i = 1; i < N; i++) {
			if(map[end] == sort[i]) continue;	// 중복제거
			map[++end] = sort[i];
		}

		for(int num : pos) {
			sb.append(getOrder(num, end, map)).append(" ");
		}
		
		System.out.print(sb);
	}
	
	// 이분탐색
	private static int getOrder(int num, int end, int[] map) {
		int start = 0;
		
		while(start <= end) {
			int mid = (start+end)/2;	// 중간 위치(index) 저장
			
			if(num == map[mid]) return mid;			// 중간이 찾는 수이면 해당 index 반환
			else if(num < map[mid]) end = mid - 1;	// 찾는 수가 중간보다 앞에 있을 때(중간 수보다 작을 때)
			else start = mid + 1;					// 찾는 수가 중간보다 뒤에 있을 때(중간 수보다 클 때)
		}
		return -1;
	}
}
