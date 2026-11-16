import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0L;
    
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
        
        char[] input = numbers.toCharArray();
        
        String now = "";
        
        for(char c : input){
            now+=c;
            
            if(numberMap.containsKey(now)){
                answer = answer * 10 + numberMap.get(now);
                now = "";
            }
        }
        
        return answer;
    }
}