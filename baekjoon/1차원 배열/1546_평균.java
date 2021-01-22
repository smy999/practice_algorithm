// 1546_평균.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double max = 0;
        double arr[] = new double[N];
        double avg = 0;
        
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            if(max < arr[i]) max = arr[i];
        }
        
        for(int i = 0; i < N; i++){
            avg += (arr[i]/max)*100;
        }
        
        System.out.printf("%.2f",avg/N);
    }
}
