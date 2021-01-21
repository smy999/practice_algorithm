// 3052_나머지.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int arr[] = new int[42];
        int tmp, result = 0;
            
        for(int i = 0; i < 10; i++){
            tmp = sc.nextInt();
            arr[tmp%42] = 1;
        }
        
        for(int i = 0; i < 42; i++){
            result += arr[i];
        }
        System.out.println(result);
    }
}
