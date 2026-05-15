class Solution {
    public int solution(int n, int[] money) {
        final int MOD = 1_000_000_007;
    
        int[] dp = new int[n+1];
        
        dp[0] = 1;
    
        for(int coin : money){
            for(int j = coin;j<=n;j++){
                dp[j] = (dp[j]+dp[j-coin])%MOD;
            }
        }
        
        return dp[n];
    }
}