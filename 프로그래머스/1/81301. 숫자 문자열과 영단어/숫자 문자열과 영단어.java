import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        Map<String,Integer> numberMap = new HashMap<>();
        
        numberMap.put("zero",0);
        numberMap.put("one",1);
        numberMap.put("two",2);
        numberMap.put("three",3);
        numberMap.put("four",4);
        numberMap.put("five",5);
        numberMap.put("six",6);
        numberMap.put("seven",7);
        numberMap.put("eight",8);
        numberMap.put("nine",9);
        
        char[] row = s.toCharArray();
        
        String now = "";
        
        for(char c : row){
            if('0'<=c && c<='9'){
                answer = answer*10+(c-'0');
                continue;
            }
            
            now = now+c;
            
            if(numberMap.getOrDefault(now,-1) != -1){
                answer = answer*10+numberMap.get(now);
                now = "";
            }
        }
        
        return answer;
    }
}