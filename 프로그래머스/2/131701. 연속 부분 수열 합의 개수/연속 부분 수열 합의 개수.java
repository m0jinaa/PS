import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int n = elements.length;
        
        int[] sum = new int[2*n+1];
        
        sum[0] = 0;
        
        for(int i = 0;i<n;i++){
            sum[i+1] = sum[i]+elements[i];
        }
        
        for(int i = 0;i<n;i++){
            sum[n+i+1] = sum[n]+sum[i+1];
        }
        
        Set<Integer> set = new HashSet<>();
                
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<n;j++){
                set.add(sum[i+j]-sum[i-1]);
            }
        }
        
        int answer = set.size();
        
        return answer;
    }
}