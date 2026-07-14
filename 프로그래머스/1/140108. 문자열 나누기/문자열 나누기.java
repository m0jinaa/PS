class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] input = s.toCharArray();
        
        final char EMPTY = ' ';
        char x = EMPTY;
        
        int a = 0;
        int b = 0;
        
        int n = input.length;
        
        for(int i = 0;i<n;i++){
            if(x == EMPTY){
                a = 1;
                b = 0;
                x = input[i];
            }    
            else if(input[i] == x){
                a++;
            }
            else{
                b++;
            }
            
            if(a == b){
                answer++;
                x = EMPTY;
            }
        }
        
        if(x!=EMPTY){
            answer++;
        }
        return answer;
    }
}