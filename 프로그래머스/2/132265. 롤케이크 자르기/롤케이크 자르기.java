import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        final int MAX = 10_000;
        
        int A = 0;
        
        int n = topping.length;
    
        int[] cntA = new int[MAX+1];
        
        for(int i = 0;i<n;i++){
            cntA[topping[i]]++;

            if(cntA[topping[i]] == 1){
                A++;
            }
        }
        
        int answer = 0;
            
        int B = 0;
        
        int[] cntB = new int[MAX+1];
        
        for(int i = 0;i<n;i++){
            cntA[topping[i]]--;
            cntB[topping[i]]++;
            
            if(cntA[topping[i]] == 0){
                A--;
            }
            
            if(cntB[topping[i]] == 1){
                B++;
            }
            
            if(A == B){
                answer++;
            }
            
            
        }

        
        return answer;
    }
}