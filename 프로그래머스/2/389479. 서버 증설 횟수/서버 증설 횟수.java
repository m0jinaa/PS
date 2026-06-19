class Solution {
    public int solution(int[] players, int m, int k) {
        final int H = 24;
        
        int answer = 0;
        
        int now = 0;
        int[] server = new int[H];
        
        int need;
        
        for(int i = 0;i<H;i++){
            now+=server[i];
            
            need = players[i]/m;
            
            if(need > now){
                answer += (need-now);
                if(i+k<H){
                    server[i+k]-=(need-now);
                }
                now = need;
            }
        }
        
        return answer;
    }
}