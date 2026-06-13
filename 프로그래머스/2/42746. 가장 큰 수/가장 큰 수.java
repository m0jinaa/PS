import java.util.stream.*;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(nums,(a,b)->(b+a).compareTo(a+b));        
        
        String answer = "0";
        
        if(!"0".equals(nums[0])){
            answer = Arrays.stream(nums).collect(Collectors.joining("")); 
        }
        
        return answer;
    }
}