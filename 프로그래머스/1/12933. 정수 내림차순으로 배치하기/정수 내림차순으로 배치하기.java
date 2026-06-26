import java.util.*;
class Solution {
    public long solution(long n) {
        LinkedList<Integer> list = new LinkedList<>();
        
        while(n > 0){
            list.add((int)(n % 10));
            n /= 10;
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
        long answer = list.stream().mapToLong(Integer::longValue).reduce(0L,(s,e)->(s*10+e));
        
        return answer;
    }
}