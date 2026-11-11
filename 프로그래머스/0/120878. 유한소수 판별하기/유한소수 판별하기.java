class Solution {
    int getGCD(int x, int y){
        int t;
        
        while(y!=0){
            t = x%y;
            x = y;
            y = t;
        }
        
        return x;
    }
    
    public int solution(int a, int b) {
        int gcd = getGCD(a,b);
        
        b/=gcd;
        
        while(b%2 == 0){
            b/=2;
        }
        
        while(b%5 == 0){
            b/=5;
        }
        
        return b == 1?1:2;
    }
}