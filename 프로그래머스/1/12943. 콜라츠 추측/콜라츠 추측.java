class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long now = num;
        
        while(now != 1L && answer<=500){
            answer++;
            
            if(now % 2 == 0){
                now /= 2;
            }
            else{
                now = (now * 3) + 1;
            }
        }
        
        if(answer > 500){
            answer = -1;
        }
        return answer;
    }
}