class Solution {
    int getGcd(int x, int y){
        int t;
        while(y!=0){
            t = x%y;
            x = y;
            y = t;
        }
        
        return x;
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1*denom2+numer2*denom1;
        int denom = denom1*denom2;
        
        int gcd = getGcd(numer,denom);
        
        numer /= gcd;
        denom /= gcd;
        
        return new int[]{numer,denom};
    }
}