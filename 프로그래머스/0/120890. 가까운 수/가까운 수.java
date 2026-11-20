class Solution {
    public int solution(int[] array, int n) {
        int answer = 1_000_000_007;
        int diff = answer;
        
        int d;
        
        for(int x : array){
            d = Math.abs(n-x);
            if(d<diff){
                answer = x;
                diff = d;
            }
            else if(d == diff && x < answer){
                answer = x;
            }
        }
        
        return answer;
    }
}