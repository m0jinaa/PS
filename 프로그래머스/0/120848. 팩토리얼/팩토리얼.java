class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        int now = 1;
        int x = 1;
        
        while(now<=n){
            answer = x;
            x++;
            now*=x;
        }
        
        return answer;
    }
}