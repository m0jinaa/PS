import java.util.*;

class Solution {
    public int solution(String S) {
        int answer = 0;
        
        char[] input = S.toCharArray();
        
        int n = input.length;
        
        LinkedList<Character> stack = new LinkedList<>();
        
        boolean possible;
        int ind;
        
        for(int s = 0;s<n;s++){
            stack.clear();
            possible = true;
            
            for(int i = 0;i<n;i++){
                ind = (s+i)%n;
                
                if(input[ind] == '[' || input[ind] == '(' || input[ind] == '{'){
                    stack.add(input[ind]);
                }
                else if(!stack.isEmpty() && input[ind] == ']' && stack.peekLast() == '['){
                    stack.pollLast();
                }
                else if(!stack.isEmpty() && input[ind] == '}' && stack.peekLast() == '{'){
                    stack.pollLast();
                }
                else if(!stack.isEmpty() && input[ind] == ')' && stack.peekLast() == '('){
                    stack.pollLast();
                }
                else{
                    possible = false;
                    break;
                }
            }
            
            if(possible && stack.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}