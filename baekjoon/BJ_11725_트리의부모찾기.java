
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_11725_트리의부모찾기 {

	static int N;
	static int[] parent;
	static ArrayList<Integer>[] node;
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		node = new ArrayList[N + 1];
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++)
			node[i] = new ArrayList<Integer>();

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			node[node1].add(node2);
			node[node2].add(node1);
		}

		parent[0] = 1; parent[1] = 1;
		bfs();

		for (int p = 2; p < parent.length; p++) sb.append(parent[p] + "\n");

		System.out.println(sb);
	}

	public static void bfs() {
		queue = new LinkedList<Integer>();
		for(int i = 0; i < node[1].size(); i++) {
			queue.add(node[1].get(i));
			parent[node[1].get(i)] = 1;
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i = 0; i < node[n].size(); i++) {
				int child = node[n].get(i);
				if(parent[child] != 0) continue;
				parent[child] = n;
				queue.add(child);
			}
		}
	}
}
