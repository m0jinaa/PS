import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        
        LinkedList<Character> list = new LinkedList<>();
        
        char[] nums = number.toCharArray();
        
        int n = nums.length;
        
        for(int i = 0;i<n;i++){
            while(k>0 &&!list.isEmpty() && list.peekLast()<nums[i]){
                list.pollLast();
                k--;
            }
            list.add(nums[i]);
        }
        
        while(k-->0){
            list.pollLast();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!list.isEmpty()){
            sb.append(list.pollFirst());
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}