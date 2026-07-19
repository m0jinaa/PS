class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] input = s.toCharArray();
        
        char[] skipping = skip.toCharArray();
        
        boolean[] isSkipped = new boolean[26];
        
        for(char c : skipping){
            isSkipped[c-'a'] = true;
        }
        
        int ind;
        int cnt = 0;
        
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        for(char c : input){
            ind = c-'a';
            cnt = 0;
            
            while(cnt<index){
                ind = (ind+1)%26;
                
                if(!isSkipped[ind]){
                    ++cnt;    
                }
            }
            
            sb.append(alpha[ind]);
        }
        
        return sb.toString();
    }
}