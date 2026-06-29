class Solution {
    public String solution(String[] seoul) {
        
        int answer = -1;
        
        final String KIM = "Kim";
        
        int n = seoul.length;
        
        for(int i = 0;i<n;i++){
            if(KIM.equals(seoul[i])){
                answer = i;
                break;
            }    
        }
        
        return "김서방은 "+answer+"에 있다";
    }
}