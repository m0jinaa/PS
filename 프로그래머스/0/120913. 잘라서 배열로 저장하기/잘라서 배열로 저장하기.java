class Solution {
    public String[] solution(String my_str, int n) {
        
        int l = my_str.length();
        
        int c = (int)Math.ceil(l*1.0/n);
        
        String[] answer = new String[c];
        
        for(int i = 0;i<c;i++){
            if(i*n+n>l){
                answer[i] = my_str.substring(i*n);
            }
            else{
                answer[i] = my_str.substring(i*n,i*n+n);
            }
        }
        
        return answer;
    }
}