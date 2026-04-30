class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        
        for(int i = 0;i<n;i++){
            dp[i+1] = (dp[i+1]+dp[i])%MOD;
            if(i+2<=n){
                dp[i+2] = (dp[i+2]+dp[i])%MOD;
            }
        }
        
        int answer = dp[n];
        return answer;
    }
}