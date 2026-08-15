import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        char[] nums = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        p--;
        
        int o = 0;
        
        int ind = 0;
        
        int number = 1;
        int now;
        
        if(p == 0){
            sb.append('0');
            --t; 
        }
        
        o = (o+1) % m;
        
        Stack<Integer> stack = new Stack<>();
        
        while(t > 0){
            now = number;
            stack.clear();
            
            while(now > 0){
                ind = now % n;
                stack.add(ind);
                now /= n;
            }
            
            while(!stack.isEmpty() && t>0){
                ind = stack.pop();
                
                if(o == p){
                    sb.append(nums[ind]);
                    --t;
                }
                
                o = (o+1) % m;
            }
            
            number++;
        }
        
        return sb.toString();
    }
}