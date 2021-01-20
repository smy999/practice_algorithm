// 2577_숫자의 개수.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int multi = A * B * C;
        int arr[] = new int[10];
        
        while(multi > 0){
            arr[multi%10]++;
            multi /= 10;
        }
        
        for(int x : arr)
            System.out.println(x);
    }
}
