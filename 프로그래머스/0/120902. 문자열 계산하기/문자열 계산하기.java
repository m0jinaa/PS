class Solution {
    public int solution(String my_string) {
        String[] expression = my_string.split(" ");
        
        final String plus = "+";
        final String minus = "-";
        
        int answer = Integer.parseInt(expression[0]);
        
        int x;
        
        int n = expression.length;
        
        for(int i = 1;i<n;i+=2){
            x = Integer.parseInt(expression[i+1]);
            
            if(plus.equals(expression[i])){
                answer+=x;
            }
            else{
                answer-=x;
            }
               
        }
        
        return answer;
    }
}