class Solution {
    public long solution(long n) {
        long sqrt = (long)Math.sqrt(n);
    
        long answer;
        
        if(sqrt*sqrt == n){
            answer = (sqrt+1)*(sqrt+1);
        }
        else{
            answer = -1;
        }
        return answer;
    }
}