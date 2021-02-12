
package 정렬;

// Collections(LinkedList) >> 시간초과
// Class Array >> 통과

import java.io.*;
import java.util.*;

public class BJ_10814_나이순_정렬 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] person = new Person[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		Arrays.sort(person, (p1, p2) -> {
			return p1.age - p2.age;
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(person[i].age + " " + person[i].name + "\n");
		System.out.print(sb);
		
	}
	
	static class Person{
		int age;
		String name;
		
		public Person() {}
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}
