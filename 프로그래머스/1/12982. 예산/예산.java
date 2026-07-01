import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        int n = d.length;
        
        for(int i = 0;i<n;i++){
            if(d[i]<=budget){
                budget-=d[i];
                answer = i+1;
            }    
            else{
                break;
            }
        }
        
        return answer;
    }
}