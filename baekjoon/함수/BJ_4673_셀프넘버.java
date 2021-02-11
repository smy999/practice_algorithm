package 함수;

public class BJ_4673_셀프넘버 {

	static boolean[] notSelfNum = new boolean[10001];

	public static void main(String[] args) {

		for(int i = 0; i <= 10000; i++) {
			int num = findSelfNum(i);
			
			if(num <= 10000) notSelfNum[num] = true;
		}

		for(int i = 1; i <= 10000; i++) 
			if(!notSelfNum[i]) System.out.println(i);
	}

	static int findSelfNum(int n) {

		int sum = n;

		while(n>0) {
			sum += n%10;
			n /= 10;
		}

		return sum;
	}

}
