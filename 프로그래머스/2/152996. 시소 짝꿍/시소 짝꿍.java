import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int n = weights.length;
        
        
        for(int i = 0;i<n;i++){
            //1:1
            answer += map.getOrDefault(weights[i],0);
            
            //1:2
            answer+=(map.getOrDefault(weights[i]*2,0));

            
            //2:3
            //2:1
            if(weights[i] % 2 == 0){
                answer+=(map.getOrDefault(weights[i]*3/2,0));
                answer+=(map.getOrDefault(weights[i]/2,0));
            }
            
            //3:4
            //3:2
            if(weights[i] % 3 == 0){
                answer+=(map.getOrDefault(weights[i]*4/3,0));
                answer+=(map.getOrDefault(weights[i]*2/3,0));
            }

            //4:3
            if(weights[i] % 4 == 0){
                answer+=(map.getOrDefault(weights[i]*3/4,0));
            }     
            
            map.put(weights[i],map.getOrDefault(weights[i],0)+1);
        }
        
        return answer;
    }
}