import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;


public class BJ_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pQueue.add(Integer.parseInt(st.nextToken()));
		}
		
		int min = 0;
		
		for(int i = N; i >= 1; i--) {
			min += pQueue.poll()*i;
		}
		
		System.out.print(min);
	}
}
