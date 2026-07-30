import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        int n = survey.length;
        
        Map<Character,Integer> map = new HashMap<>();
        
        char c;
        
        for(int i = 0;i<n;i++){
            if(choices[i]==4){
                continue;
            }else if(choices[i]<4){
                c = survey[i].charAt(0);
                
                map.put(c, map.getOrDefault(c,0)+(4-choices[i]));
            }
            else{
                c = survey[i].charAt(1);
                
                map.put(c, map.getOrDefault(c,0)+(choices[i]-4));
            }
        }
        
        sb.append((map.getOrDefault('R',0)>=map.getOrDefault('T',0))?"R":"T");
        sb.append((map.getOrDefault('C',0)>=map.getOrDefault('F',0))?"C":"F");
        sb.append((map.getOrDefault('J',0)>=map.getOrDefault('M',0))?"J":"M");
        sb.append((map.getOrDefault('A',0)>=map.getOrDefault('N',0))?"A":"N");
        
        return sb.toString();
    }
}