class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] input = s.toCharArray();
        
        if(s.length() != 4 && s.length() != 6){
            answer = false;
        }
        else{
            for(char c : input){
                if(c<'0' || c>'9'){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}