import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] dp = new int[n][n];
        
        for(int[] result : results){
            dp[result[0]-1][result[1]-1] = 1;
            dp[result[1]-1][result[0]-1] = -1;
        }
        
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                if(i == k){
                    continue;
                }
                for(int j = 0;j<n;j++){
                    if(i == j || j == k || dp[i][k] == 0 || dp[k][j] == 0 || dp[i][j] != 0){
                        continue;
                    }
                    else if(dp[i][k] == dp[k][j]){
                        dp[i][j] = dp[i][k];
                    }
                }
            }
        }
        
        boolean canFigure;
        int answer = 0;
        
        for(int i = 0;i<n;i++){
            canFigure = true;
            
            for(int j = 0;j<n;j++){
                if(i != j && dp[i][j] == 0){
                    canFigure = false;
                    break;
                }
            }
            
            if(canFigure){
                answer++;
            }
        }
        return answer;
    }
}