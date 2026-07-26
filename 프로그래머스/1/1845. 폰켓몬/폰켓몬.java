class Solution {
    public int solution(int[] nums) {
        
        final int MAX = 200_000;
        
        boolean[] exists = new boolean[MAX+1];
            
        int cnt = 0;
        
        for(int x : nums){
            if(exists[x]){
                continue;
            }
            exists[x] = true;
            cnt++;
        }
        
        int limit = nums.length/2;
        
        int answer = Math.min(cnt, limit);
        
        return answer;
    }
}