class Solution {
    int getGCD(int x, int y){
        int t;
        
        while(y > 0){
            t = x % y;
            x = y;
            y = t;
        }
        
        return x;
    }
    public long[] solution(int n, int m) {
        int[] answer = {};
        
        int gcd = getGCD(n,m);
        
        long lcm = 1L* n * m / gcd;
        
        return new long[]{1L*gcd,lcm};
    }
}