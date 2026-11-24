import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String numbers = my_string.replaceAll("[^0-9]+","");
        char[] nums = numbers.toCharArray();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int[] answer = new int[n];
        
        for(int i = 0;i<n;i++){
            answer[i] = nums[i]-'0';
        }
        
        return answer;
    }
}