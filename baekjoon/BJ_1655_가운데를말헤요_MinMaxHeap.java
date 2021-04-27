import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

// maxHeap이 작은 수를, minHeap에 큰 수를 넣는다.
// maxHeap의 맨 앞이 중간값, minHeap의 맨 앞이 중간값의 다음값

public class BJ_1655_가운데를말헤요_MinMaxHeap {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((p1, p2) -> p2 - p1);
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i % 2 == 0) maxHeap.add(num);	// 한번은 maxHeap, 
			else minHeap.add(num);				// 한번은 minHeap에 넣는다.

			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				// minHeap의 최소값이 maxHeap의 최대값보다 작으면 두 값을 swap
				if(maxHeap.peek() > minHeap.peek()) {
					int tmp = maxHeap.poll();
					maxHeap.add(minHeap.poll());
					minHeap.add(tmp);
				}
			}
			// 가운데에 위치하는 숫자가 maxHeap의 root값
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.print(sb);
	}
}

