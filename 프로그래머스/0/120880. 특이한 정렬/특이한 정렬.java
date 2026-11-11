import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> {
                    int d1 = Math.abs(n - a);
                    int d2 = Math.abs(n - b);
                    
                    if (d1 == d2) {
                        return b - a;
                    } else {
                        return d1 - d2;
                    }
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}