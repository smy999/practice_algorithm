
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286_절대값힙 {

	static int N, pre;
	static PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] p1, int[] p2) {
			if(p1[0] == p2[0]) return p1[1] - p2[1];
			return p1[0] - p2[0];
		}
	});
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(queue.isEmpty()) sb.append(0).append("\n");
				else sb.append(queue.poll()[1]).append("\n");
			}
			
			else {
				queue.add(new int[] {Math.abs(num), num});
			}
		}
		System.out.print(sb);
	}
}
