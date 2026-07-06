import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int x : arr){
            if(list.isEmpty() || list.peekLast()!=x){
                list.add(x);
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}