import java.util.*;
class Solution {
    public double solution(int[] arr) {
        
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        
        double answer = sum*1.0/n;
        return answer;
    }
}