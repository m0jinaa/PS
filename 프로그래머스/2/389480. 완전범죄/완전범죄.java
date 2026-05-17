import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int[] dp = new int[m];
        Arrays.fill(dp,-1);
        
        dp[0] = 0;
        
        int a,b;
        
        int total = 0;
        
        for(int[] mark : info){
            a = mark[0];
            b = mark[1];
            
            total += a;    
            
            for(int i = m-1;i>=b;i--){
                if(dp[i-b] == -1){
                    continue;
                }
                
                dp[i] = Math.max(dp[i],dp[i-b]+a);
            }
        }
        
        int max = 0;
        
        for(int i = 0;i<m;i++){
            max = Math.max(max,dp[i]);
        }
        
        int answer = total-max;
        
        if(answer>=n){
            answer = -1;
        }
        
        return answer;
    }
}