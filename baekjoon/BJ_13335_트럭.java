package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13335_트럭 {

	static class Truck {
		int w, loc;
		public Truck(int w, int loc) {
			this.w = w;
			this.loc = loc;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 다리를 건너는 트럭의 수
		int W = Integer.parseInt(st.nextToken());	// 다리의 길이
		int L = Integer.parseInt(st.nextToken());	// 다리의 최대 하중
		
		int[] trucks = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		int weight = 0;	// 다리를 건너는 트럭 무게의 총합
		int time = 0;	// 모든 트적이 다리를 건너는 최단 시간(결과)
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			while(true) {
				
				if(queue.isEmpty()) {	// 다리를 건너는 트럭이 없을 때
					queue.add(trucks[i]);
					time++;
					weight += trucks[i];
					break;
				}
				
				if(queue.size() == W) {	// 다리를 다 건넜을 때
					weight -= queue.poll();
				}
				else if(weight + trucks[i] > L) {	// 최대 하중을 초과할 때
					queue.add(0);
					time++;
				} else {	// 최대 하중 이하일 때
					queue.add(trucks[i]);
					time++;
					weight += trucks[i];
					break;
				}
				
			}
		}
		
		
		System.out.print(time + W);	// 시간 + 마지막 트럭이 다리를 건너는 시
	}
}
