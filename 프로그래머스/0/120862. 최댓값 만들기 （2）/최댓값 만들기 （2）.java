import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        
        int n = numbers.length;
        
        int answer = Math.max(numbers[0]*numbers[1],numbers[n-1]*numbers[n-2]);        
        
        return answer;
    }
}