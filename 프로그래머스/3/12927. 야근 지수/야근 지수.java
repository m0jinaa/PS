import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0L;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            q.add(work);
        }
        
        int now;
        
        while(n-->0 && !q.isEmpty()){
            now = q.poll();
            
            if(now>1){
                q.add(now-1);
            }
        }
        
        while(!q.isEmpty()){
            now = q.poll();
            
            answer += (now * now);
        }
        
        return answer;
    }
}