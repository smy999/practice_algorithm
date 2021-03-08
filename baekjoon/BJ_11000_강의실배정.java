
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_11000_강의실배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] room = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(room, new Comparator<int[]>() {
			@Override
			public int compare(int[] r1, int[] r2) {
				if(r1[0] == r2[0]) return r1[1] - r2[1];
				else return r1[0] - r2[0];
			}
		});
		
		for (int[] t : room)
			System.out.println(Arrays.toString(t));

		PriorityQueue<Integer> pqueue = new PriorityQueue<>();
		pqueue.add(room[0][1]);

		for (int i = 1; i < N; i++) {
			if (pqueue.peek() <= room[i][0]) pqueue.poll();
			pqueue.add(room[i][1]);
			for(int q : pqueue) System.out.print(q + " ");
			System.out.println();
		}

		System.out.print(pqueue.size());
	}
}
