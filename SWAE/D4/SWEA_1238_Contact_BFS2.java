package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_1238_Contact_풀이 {
	
	static int L, S, maxNum, maxDepth;
	static boolean[][] graph;
	static boolean[] visited;
	static Queue<Node> queue = new LinkedList<Node>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			
			graph = new boolean[101][101];
			visited = new boolean[101];
			maxNum = Integer.MIN_VALUE;
			maxDepth = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < L/2; i++)
				graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			
			visited[S] = true;
			queue.offer(new Node(S, 0));	// 시작점, 깊이
			
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				if(node.d > maxDepth) {
					maxDepth = node.d;
					maxNum = node.n;
				} else if(node.d == maxDepth){
					maxNum = Math.max(maxNum, node.d);
				}

				for(int i = 1; i < 101; i++) {
					if(graph[node.n][i] && visited[i]) continue;
					visited[i] = true;
					queue.offer(new Node(i, node.d+1));
				}
			}
			queue.clear();
			System.out.println("#" + t + " "+ maxNum);
		}
		
	}
	
	static class Node {
		int n;
		int d;
		public Node(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}
}
