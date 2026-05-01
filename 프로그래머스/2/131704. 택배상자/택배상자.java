import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int n = order.length;
        
        Stack<Integer> stack = new Stack<>();
        
        int belt = 1;
        
        for(int i = 0;i<n;i++){
            if(!stack.isEmpty() && stack.peek()==order[i]){
                stack.pop();
                answer++;
            }
            else if(belt<=order[i]){
                while(belt<order[i]){
                    stack.add(belt++);
                }
                belt++;
                answer++;
            }
            else{
                break;
            }
        }
        
        return answer;
    }
}