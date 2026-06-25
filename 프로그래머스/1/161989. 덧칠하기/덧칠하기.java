class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int now = 0;
        
        for(int s : section){
            if(now < s){
                answer++;
                now = s + m - 1;
            }
            else{
                continue;
            }
        }
        
        return answer;
    }
}