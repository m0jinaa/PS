class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 0){
                    continue;
                }
                else if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    
                }
                
                answer = Math.max(answer, dp[i][j]*dp[i][j]);
            }
        }
        
        return answer;
    }
}