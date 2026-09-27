class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target+1][2];
        
        for(int i = 1;i<=target;i++){
            dp[i][0] = target+1;
            dp[i][1] = -1;
        }
        
        for(int i = 0;i<target;i++){
            
            //현재점수가 i일 때
            
            for(int j = 1;j<=20;j++){
                //싱글
                if(i+j>target){
                    continue;
                }
                
                if(dp[i+j][0]>dp[i][0]+1 || (dp[i+j][0]== dp[i][0]+1)&&dp[i+j][1]<dp[i][1]+1){
                    dp[i+j][0] = dp[i][0]+1;
                    dp[i+j][1] = dp[i][1]+1;
                }
                
                //더블
                if(i+2*j>target){
                    continue;
                }
                
                if(dp[i+2*j][0]>dp[i][0]+1 || (dp[i+2*j][0]== dp[i][0]+1)&&dp[i+2*j][1]<dp[i][1]){
                    dp[i+2*j][0] = dp[i][0]+1;
                    dp[i+2*j][1] = dp[i][1];
                }
                
                //트리플
                if(i+3*j>target){
                    continue;
                }
                
                if(dp[i+3*j][0]>dp[i][0]+1 || (dp[i+3*j][0]== dp[i][0]+1)&&dp[i+3*j][1]<dp[i][1]){
                    dp[i+3*j][0] = dp[i][0]+1;
                    dp[i+3*j][1] = dp[i][1];
                }
            }
            
            //불
            if(i+50 > target){
                continue;
            }

            if(dp[i+50][0]>dp[i][0]+1 || (dp[i+50][0]== dp[i][0]+1)&&dp[i+50][1]<dp[i][1]+1){
                dp[i+50][0] = dp[i][0]+1;
                dp[i+50][1] = dp[i][1]+1;
            }        
        }
        
        int[] answer = dp[target];
        
        return answer;
    }
}

