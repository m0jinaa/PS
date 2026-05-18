class Solution {
    long gcd(long a, long b){
        
        long temp;
        
        while(b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    public long solution(int[] arr) {
        
        long g;
        
        int n = arr.length;
        
        long lcm = 1L*arr[0];
        
        for(int i = 1; i < n; i++){
            g = gcd(lcm, 1L * arr[i]);
            
            lcm = (lcm * arr[i]) / g;
        }
        
        
        return lcm;
    }
}