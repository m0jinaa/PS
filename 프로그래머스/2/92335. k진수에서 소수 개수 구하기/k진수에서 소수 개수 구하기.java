import java.util.*;
class Solution {
    public int solution(int n, int k) {
        final String ZERO = "0";
        final String ONE = "1";
        
        int answer = (int)Arrays.stream(Integer.toString(n,k).split(ZERO))
            .filter(s->!s.isEmpty() && !ONE.equals(s))
            .mapToLong(Long::parseLong)
            .filter(x-> 
                    {
                        for(long y = 2;y*y<=x;y++){
                            if(x % y == 0){
                                return false;
                            }
                        }
                        return true;
                    })
            .count();
        return answer;
    }
}