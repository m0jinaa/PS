class Solution {
    public int solution(int left, int right) {
        int answer = (left+right)*(right-left+1)/2;
        
        for(int i = 1;i*i<=right;i++){
            if(i*i>=left){
                answer-=i*i*2;
            }
        }
        
        return answer;
    }
}