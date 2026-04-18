
class Solution {
    boolean solution(String s) {
        int open = 0;
        boolean answer = true;
        
        char[] input = s.toCharArray();
    
        for(char c : input){
            if(c == '('){
                open++;
            }
            else if(open>0){
                open--;
            }
            else{
                answer = false;
                break;
            }
        }
        
        answer &= (open == 0);
        
        return answer;
    }
}