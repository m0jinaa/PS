class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int s = 0;
        int e = 0;
        
        int sum = 0;
        
        while(s<=e){
            if(sum==n){
                answer++;
                sum+=(++e);
            }
            else if(sum<n){
                sum+=(++e);
            }
            else{
                sum-=(s++);
            }
        }
        return answer;
    }
}