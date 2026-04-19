import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        char[] input = s.toCharArray();
        
        for(char c : input){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        
        int answer = stack.isEmpty()?1:0;
        
        return answer;
    }
}