package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고: https://geehye.github.io/baekjoon-9466/#
// dfs

public class BJ_9466_텀프로젝트_DFS {

	static int N, cnt;
	static int[] students;
	static boolean[] visited, finished;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			// 학생 수 입력
			N = Integer.parseInt(br.readLine());
			
			// 학생 정보 입력
			students = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			
			// 해당 학생을 방문했는지 안했는지 표시하는 배열 >> finished만 사용하여 시간초과 발생
			visited = new boolean[N+1];
			// 해당 학생의 검사가 끝났는지 아닌지 표시하는 배열
			finished = new boolean[N+1];
			
			cnt = 0;
			
			// dfs를 이용하여 팀 구하기
			for(int i = 1; i <= N; i++) {
				if(!finished[i]) dfs(i);
			}
			
			sb.append(N-cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void dfs(int no) {
		// 방문한 곳을 다시 방문했다? 사이클 형성! = 팀 형성!
		if(visited[no]) {
			finished[no] = true;
			cnt++;
		} 
		// 처음 방문한 곳이면 방문 표시해주고 넘어가기
		else {
			visited[no] = true;
		}
		
		// 현재 학생이 선택한 학생 저장
		int choosenNo = students[no];

		// 선택한 학생이 팀이 없으면 dfs 탐색으로 팀 찾기
		if(!finished[choosenNo]) dfs(choosenNo);
		
		visited[no] = false;	// 다음 검사를 위해 visited는 false로 변경한다. >> dfs에서 visited 돌려놓는 것과 같은 원리!
		finished[no] = true;	// 해당 학생은 검사가 끝났다.(팀을 이루는지 아닌지에 상관없이)
	}
}
