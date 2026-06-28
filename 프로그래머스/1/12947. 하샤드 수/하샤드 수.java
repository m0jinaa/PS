class Solution {
    public boolean solution(int x) {
        int digit = 0;
        
        int t = x;
        
        while(t>0){
            digit+=(t%10);
            t/=10;
        }
        
        return (x % digit) == 0;
    }
}