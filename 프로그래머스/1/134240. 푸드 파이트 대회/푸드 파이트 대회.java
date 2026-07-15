import java.util.Stack;

class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        int n = food.length;
        
        int c;
        
        for(int i = 1;i < n; i++){
            c = food[i]/2;
            while(c-->0){
                sb.append(i);
                stack.add(i);
            }
        }
        
        sb.append(0);
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}