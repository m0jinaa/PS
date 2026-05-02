class Solution {
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[]{-1};
        }
        else{
            int[] answer = new int[n];
            
            int x = s/n;
            int r = s%n;
            
            for(int i = 0;i<n;i++){
                if(i+r>=n){
                    answer[i] = x+1;
                }
                else{
                    answer[i] = x;
                }
            }
        
            return answer;
        }
    }
}