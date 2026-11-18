import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        String[] list = s.split(" ");
        
        for(String word : list){
            if("Z".equals(word)){
                stack.pop();
            }
            else{
                stack.add(Integer.parseInt(word));
            }
        }
        
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        
        return answer;
    }
}