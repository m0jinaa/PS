class Solution {
    public long solution(int n) {
        final int MOD = 1_234_567;
        
        long[] dp = new long[n + 1];
        dp[0] = 1L;
        dp[1] = 1L;
        
        for(int i = 2;i <= n;i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}