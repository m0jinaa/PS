import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[n+1];
        
        Arrays.fill(isPrime,true);
        
        isPrime[0] = isPrime[1] = false;
    
        int limit = (int)Math.sqrt(n);
        
        for(int i = 2;i<=n;i++){
            if(!isPrime[i]){
                continue;
            }
            answer++;
            
            if(i>limit){
                continue;
            }
            
            for(int j = i*i;j<=n;j+=i){
                isPrime[j] = false;
            }
        }
        
        return answer;
    }
}