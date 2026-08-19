import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        char[] row;
        
        Set<String> canPronounce = new HashSet<>();
        
        canPronounce.add("aya");
        canPronounce.add("ye");
        canPronounce.add("woo");
        canPronounce.add("ma");

        Set<String> said = new HashSet<>();
        
        String w;
        boolean right;
        
        for(String word: babbling){
            said.clear();
            row = word.toCharArray();    
            right = true;    
            w = "";
            for(char c : row){
                w+=c;
                
                if(canPronounce.contains(w)){
                    if(said.contains(w)){
                        right = false;
                        break;
                    }
                    said.add(w);
                    w = "";
                }
            }
            
            if("".equals(w) && right){
                answer++;
            }
        }
        
        return answer;
    }
}