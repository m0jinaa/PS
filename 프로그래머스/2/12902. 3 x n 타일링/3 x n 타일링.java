class Solution {
    public long solution(int n) {
        final int MOD = 1_000_000_007;
        
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        
        for(int i = 1;i<=n;i++){
            if(i%2 != 0){
                continue;
            }
            else{
                dp[i] = (3*dp[i-2])%MOD;
                
                for(int j = i-4;j>=0;j-=2){
                    dp[i] = (dp[i]+dp[j]*2)%MOD;
                }
            }
        }
        
        return dp[n];
    }
}