// 2588_곱셈.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int result = 0;
        
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        for(int i = 1; num2 > 0; i*=10){
            System.out.println(num1*(num2%10));
            result += num1*(num2%10)*i;
            num2 = num2/10;
        }
        
        System.out.println(result);
    }
}
