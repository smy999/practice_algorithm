package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_14719_빗물_구현 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2차원 세계의 크기 입력, 사실상 H는 불필요
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		// 블록과 가장 높이가 높은 블록의 위치를 저장하는 자료구조
		int[] block = new int[W];
		ArrayList<Integer> maxList = new ArrayList<>();
		
		int max = 0;
		
		// 입력하면서 가장 높이가 높은 블록의 높이 구하기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, block[i]);
		}
		
		// 가장 높이가 높은 블럭들을 저장하는 리스트
		for(int i = 0; i < W; i++) {
			if(block[i] == max) maxList.add(i);
		}

		// 빗물의 합: 결과
		int sum = 0;
		
		// 첫번째로 위치하는 가장 높이가 높은 블록 이전에 고인 빗물 계산
		max = block[0];
		for(int i = 0; i < maxList.get(0); i++) {
			if(max > block[i+1]) {
				sum += max - block[i+1];
			} else {
				max = block[i+1];
			}
		}
		
		// 첫번째와 마지막에 위치하는 가장 높이가 높은 블록 사이에 고인 빗물 계산
		max = block[maxList.get(0)];
		for(int j = maxList.get(0)+1; j < maxList.get(maxList.size()-1); j++) {
			sum += max - block[j];
		}
		
		// 마지막으로 위치하는 가장 높이가 높은 블록 이후에 고인 빗물 계산
		max = block[W-1];
		for(int i = W-1; i > maxList.get(maxList.size()-1); i--) {
			if(max > block[i-1]) {
				sum += max - block[i-1];
			} else {
				max = block[i-1];
			}
		}
		
		System.out.print(sum);
	}
}
