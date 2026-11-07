class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        //(x,y) 라고 할 때 r1^2<=x^2+y^2<=r2^2를 만족해야 함.
        
        long s,e;
        long c;
        
        for(int x = 0;x<=r2;x++){
            s = (long)Math.ceil(Math.sqrt(1L*r1*r1-1L*x*x));
            e = (long)Math.sqrt(1L*r2*r2-1L*x*x);
            
            c = (e-s+1)*2;
            
            if(s == 0){
                c--;
            }
            
            if(x == 0){
                answer += c;
            }
            else{
                answer += 2*c;
            }
        }
        
        return answer;
    }
}