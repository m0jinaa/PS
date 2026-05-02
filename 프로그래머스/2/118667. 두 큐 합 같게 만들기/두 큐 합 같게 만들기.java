import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int n = queue1.length;
        int m = queue2.length;
        
        LinkedList<Integer> q1 = new LinkedList<>();
        
        long sum1 = 0L;
        for(int x : queue1){
            q1.add(x);
            sum1 += x;
        }
        
        LinkedList<Integer> q2 = new LinkedList<>();
        
        long sum2 = 0L;
        for(int x : queue2){
            q2.add(x);
            sum2 += x;
        }
        
        int x;
        int limit = 2*(n+m);
        while(sum1 != sum2 && answer < limit){
            if(sum1<sum2){
                x = q2.poll();
                sum2-=x;
                sum1+=x;
                q1.add(x);
            }
            else{
                x = q1.poll();
                sum1-=x;
                sum2+=x;
                q2.add(x);
            }
            answer++;
        }
        
        if(answer == limit){
            answer = -1;
        }
        
        return answer;
    }
}