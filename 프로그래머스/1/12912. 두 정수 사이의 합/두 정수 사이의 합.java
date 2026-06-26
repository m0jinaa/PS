class Solution {
    public long solution(int a, int b) {
        
        if(a > b){
            int t = a;
            a = b;
            b = t;
        }
        
        long answer = (1L*a+1L*b)*(b-a+1)/2;
        
        return answer;
    }
}