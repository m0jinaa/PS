import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        int[] nums = new int[]{1,2,4};
        
        while(n>0){
            n--;
            stack.add(n%3);
            n/=3;
        }
        
        int ind;
        
        while(!stack.isEmpty()){
            ind = stack.pop();
            sb.append(nums[ind]);
        }
        
        return sb.toString();
    }
}