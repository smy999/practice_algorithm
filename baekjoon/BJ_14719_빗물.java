package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_14719_빗물 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] block = new int[W];
		ArrayList<Integer> maxList = new ArrayList<>();
		
		int idx = 0, max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			int h = Integer.parseInt(st.nextToken());
			block[i] = h;
			if(max < h) {
				max = h; idx = i;
			}
		}
		
		for(int i = 0; i < W; i++) {
			if(block[i] == max) maxList.add(i);
		}

		int sum = 0;
		
		max = block[0];
		idx = 0;
		for(int i = 0; i < maxList.size(); i++) {
			for(int j = idx; j < maxList.get(i); j++) {
				if(max > block[j+1]) {
					sum += max - block[j+1];
				} else {
					max = block[j];
				}
			}
			if(i+1 < W) max = block[i+1];
			idx += 2;
		}
		
		max = block[W-1];
		for(int i = W-1; i > idx; i--) {
			if(max > block[i-1]) {
				sum += max - block[i-1];
			} else {
				max = block[i];
			}
		}
		
		System.out.print(sum);
	}
}
