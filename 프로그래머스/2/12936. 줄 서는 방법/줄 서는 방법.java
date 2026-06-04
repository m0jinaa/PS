import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        int ind;
        
        long fact = 1L;
        
        for(int i =1;i<=n;i++){
            fact *= i;
        }
        
        boolean[] used = new boolean[n + 1];
        
        k--;
        
        for(int i = 0;i<n;i++){
            fact /= (n-i);
            
            ind = (int)(k/fact);
            
            for(int j = 1;j <= n;j++){
                if(used[j]){
                    continue;
                }
                else if(ind == 0){
                    answer[i] = j;
                    used[j] = true;
                    break;
                }
                
                ind--;
            }
            
            k %= (fact);
        }
        
        return answer;
        
    }
}