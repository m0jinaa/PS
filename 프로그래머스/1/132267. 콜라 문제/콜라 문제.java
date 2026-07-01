class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int t;
        
        int cola;
        
        while(a <= n){
            t = n/a;
            cola = b * t;
            answer += cola;
            n%=a;
            n += cola;
        }
        return answer;
    }
}