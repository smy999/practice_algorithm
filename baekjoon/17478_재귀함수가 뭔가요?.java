package workshop;
// 재귀함수가 뭔가요?

import java.util.Scanner;

// 1 <= N <= 50: 재귀 호출 홧수
public class BJ_17478 {

	static int N;
	static String ub = "";
	static String[] answer = { "\"재귀함수가 뭔가요?\"",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
			"라고 답변하였지."};
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		whatIsRecursion(0);
		
		sc.close();
	}

	private static void whatIsRecursion(int n) {
		
		if(n > N) return;
		
		if(n == N) {
			System.out.println(sb + answer[0]);
			System.out.println(sb + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			// return;
		}
		else {
		for(int i = 0; i < 4; i++)
			System.out.println(sb + answer[i]);
		}
		sb.append("____");
		
		whatIsRecursion(n+1);
		
		sb.setLength(n*4);
		System.out.println(sb + answer[4]);
		
	}
}
