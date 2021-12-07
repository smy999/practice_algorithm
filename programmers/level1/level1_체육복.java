import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int sizeL = lost.length;
        int sizeR = reserve.length;
        int cnt = 0;
        
        for(int i = 0; i < sizeL; i++) {
            for(int j = 0; j < sizeR; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = reserve[j] = -1;
                    cnt++;
                    break;
                }
            }
        }

        for(int i = 0; i < sizeL; i++) {
            for(int j = 0; j < sizeR; j++) {
                if((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    cnt++;
                    reserve[j] = -1;
                    break;
                } 
            }
        }

        return n-sizeL+cnt;
    }
}
