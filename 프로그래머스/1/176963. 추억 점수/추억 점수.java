import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> memory = new HashMap<>();
        
        int n = name.length;
        
        for(int i = 0;i<n;i++){
            memory.put(name[i],yearning[i]);
        }
    
        int[] answer = Arrays.stream(photo).mapToInt((String[] arr) -> Arrays.stream(arr).mapToInt((String s)->memory.getOrDefault(s,0)).sum()).toArray();
        
        return answer;
    }
}