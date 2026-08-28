class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int n = common.length;
        
        if(common[n-1]-common[n-2] == common[n-2]-common[n-3]){
            answer = common[n-1]*2-common[n-2];
        }
        else{
            answer = common[n-1]*common[n-1]/common[n-2];
        }
        
        return answer;
    }
}