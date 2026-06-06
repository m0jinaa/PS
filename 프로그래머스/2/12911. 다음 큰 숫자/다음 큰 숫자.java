class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int target = Integer.bitCount(n);
        
        int now = n+1;
        
        while(true){
            if(Integer.bitCount(now)==target){
                answer = now;
                break;
            }
            else{
                now++;
            }
        }
        
        return answer;
    }
}