class Solution {
    int solution(int[][] land) {
        final int COL = 4;
        int n = land.length;
        
        int answer = 0;
        
        int[][] dp = new int[n][COL];
        
        for(int i = 0;i<COL;i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][3]))+land[i][0];         
            dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-1][2],dp[i-1][3]))+land[i][1];         
            dp[i][2] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][3]))+land[i][2];         
            dp[i][3] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]))+land[i][3];
        }
        
        for(int i= 0;i<COL;i++){
            answer = Math.max(answer,dp[n-1][i]);
        }
        return answer;
    }
}