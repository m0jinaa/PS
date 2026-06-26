import java.util.*;

class Solution {
    public int[] solution(long n) {
        LinkedList<Integer> list = new LinkedList<>();
        
        while(n>0){
            list.add((int)(n%10));
            n /= 10;
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}