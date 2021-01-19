// 10871_x보다 작은 수.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int N, X, A;
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        X = sc.nextInt();
        
        for(int i = 0; i < N; i++){
            A = sc.nextInt();
            
            if(A < X)
                System.out.print(A + " ");
        }
    }
}
