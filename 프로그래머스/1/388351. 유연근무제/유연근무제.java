class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        int d;
        boolean success;
        int limit;
        
        for(int i = 0;i<n;i++){
            success = true;
            d = startday - 1;
            limit = schedules[i] + 10;
            
            if(limit % 100 >= 60){
                limit += 40;
            }
            
            for(int j = 0;j < 7; j++){
                if(d == 5 || d == 6){
                    d = (d + 1) % 7;
                    continue;
                }
                
                if(timelogs[i][j] > limit){
                    success = false;
                    break;
                }
                
                d = (d + 1) % 7;
            }

            if(success){
                answer++;
            }
        }
        return answer;
    }
}