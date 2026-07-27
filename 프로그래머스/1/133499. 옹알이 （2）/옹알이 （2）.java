import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String bef = "";
        
        char[] input;
        String now;
        
        Set<String> canSay = new HashSet<>();
        
        canSay.add("aya");
        canSay.add("ye");
        canSay.add("woo");
        canSay.add("ma");
        
        boolean possible;
        String EMPTY = "";
        
        for(String word : babbling){
            input = word.toCharArray();
            bef = EMPTY;
            now = EMPTY;
            possible = true;
            
            for(char c : input){
                now = now+c;
                
                if(canSay.contains(now)){
                    if(bef.equals(now)){
                        possible = false;
                        break;
                    }
                    bef = now;
                    now = EMPTY;
                }
            }
            
            if(possible && EMPTY.equals(now)){
                answer++;
            }
            
        }
        
        return answer;
    }
}