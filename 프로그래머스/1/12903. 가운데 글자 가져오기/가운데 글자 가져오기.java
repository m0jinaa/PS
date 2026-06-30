class Solution {
    public String solution(String s) {
        int n = s.length();
        
        String answer;
        
        if(n%2 == 0){
            answer = s.substring(n/2-1,n/2+1);
        }
        else{
            answer = s.substring(n/2,n/2+1);
        }
        return answer;
    }
}