import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
    static int dump;
    static int[] arr;
	
    public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{      
            dump = sc.nextInt();
            
            arr = new int[100];
			for(int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
    
            Arrays.sort(arr);
			for(int d = 0; d < dump; d++) {
				if(arr[99] - arr[0] <= 1) break;
				arr[99]--; arr[0]++;
				Arrays.sort(arr);
			}
            System.out.println("#" + test_case + " " + (arr[99] - arr[0]));
		}
	}
}
