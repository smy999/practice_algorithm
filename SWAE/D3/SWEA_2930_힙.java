import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class SWEA_2930_힙 {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input_2930.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1);
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				if(op == 1) pq.add(Integer.parseInt(st.nextToken()));
				else {
					if(pq.isEmpty()) sb.append(-1).append(" ");
					else sb.append(pq.poll()).append(" ");
				}
			}
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
}
