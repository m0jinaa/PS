import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, Comparator.comparing((String x)->x.charAt(n)).thenComparing(x->x));
        
        return strings;
    }
}