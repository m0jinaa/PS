import java.util.*;

class Solution {
    int gcd(int x, int y){
        int t;
        
        while(y!=0){
            t = x%y;
            x = y;
            y = t;
        }
        
        return x;
    }
    public int solution(int[][] signals) {
        int answer = -1;
        
        int lcm = 1;
        
        int sum;
        
        for(int[] signal : signals){
            sum = Arrays.stream(signal).sum();
            lcm = lcm * sum / gcd(lcm, sum);
        }
        
        boolean yellow;
        
        int s;
        
        for(int t = 1;t<=lcm;t++){
            yellow = true;
            
            for(int[] signal : signals){
                sum = Arrays.stream(signal).sum();
                s = t%sum;
                
                if(s<=signal[0] || s>signal[0]+signal[1]){
                    yellow = false;
                    break;
                }
            }
            
            if(yellow){
                answer = t;
                break;
            }
        }
        
        return answer;
    }
}