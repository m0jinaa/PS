import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int p : scoville){
            pq.add(1L*p);
        }
        
        long x,y;
        
        while(pq.peek()<K && pq.size()>1){
            //섞는 횟수 증가
            answer++;
            
            //스코빌지수가 낮은 두 음식 가져오기
            x = pq.poll();
            y = pq.poll();
            
            //음식 섞기
            pq.add(x+2*y);
        }
        
        //K 이상으로 만들 수 없는 경우 체크
        if(pq.peek()<K){
            answer = -1;
        }
        
        return answer;
    }
}