import java.util.*;

class Solution {
    boolean[] isPrime;
    
    void init(int n){
        isPrime = new boolean[n+1];
        
        Arrays.fill(isPrime, true);
        
        isPrime[0] = isPrime[1] = false;
        
        for(int i =2;i<=n;i++){
            if(!isPrime[i]){
                continue;
            }
            
            for(int j = i*i;j<=n;j+=i){
                isPrime[j] = false;
            }
        }
    }
    
    public int solution(int n) {
        
        init(n);
        
        int answer = 0;
        
        for(int i = 4; i<=n;i++){
            if(!isPrime[i]){
                answer++;
            }
        }
        
        return answer;
    }
}