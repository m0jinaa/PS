class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int start = 1<<(n-1);
        
        int now;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<n;i++){
            now = start;
            
            for(int j = 0;j<n;j++, now/=2){
                
                if((now&arr1[i]) != 0 || (now&arr2[i]) != 0){
                    sb.append("#");
                }    
                else{
                    sb.append(" ");
                }
            }
            
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}