class Solution {
    
    public int solution(int[] number) {
        final int MAX = 6000;
        int[][] dp = new int[4][MAX+1];
        
        dp[0][3000] = 1;
        
        for(int x : number){
            for(int i = 2;i>=0;i--){
                for(int j = 0;j<=MAX;j++){
                    if(dp[i][j] == 0){
                        continue;
                    }
                    
                    dp[i+1][j+x]+=dp[i][j];
                }
            }
        }
        
        return dp[3][3000];
    }
}