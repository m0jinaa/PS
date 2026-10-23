class Solution {
    public int gcd(int x, int y){
        int t;
        
        while(y!=0){
            t = x%y;
            x = y;
            y = t;
        }
        
        return x;
    }
    
    public long solution(int w, int h) {
        //꼭짓점에서 지나는 경우는 제외해야하니까 최대공약수 구하기
        long answer = 1L*w*h-(w+h-gcd(w,h));
        
        return answer;
    }
}