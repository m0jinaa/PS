import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        char[] row = my_string.toCharArray();
        
        for(char c : row){
            if(set.contains(c)){
                continue;
            }
            sb.append(c);
            set.add(c);
        }
        
        return sb.toString();
    }
}