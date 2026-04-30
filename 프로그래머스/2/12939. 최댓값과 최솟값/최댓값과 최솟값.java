class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int n = nums.length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int x;
        
        for(int i = 0;i<n;i++){
            x = Integer.parseInt(nums[i]);
            
            min = Math.min(min,x);
            max = Math.max(max,x);
        }
        
        String answer = min+" "+max;
        return answer;
    }
}