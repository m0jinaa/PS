import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        LinkedList<Integer> release = new LinkedList<>();
        
        int n = progresses.length;
        
        int limit = (int)Math.ceil((100-progresses[0])*1.0/speeds[0]);
        int cnt = 1;
        int time;
        
        for(int i = 1;i<n;i++){
            time = (int)Math.ceil((100-progresses[i])*1.0/speeds[i]);
            
            if(time>limit){
                release.add(cnt);
                limit = time;
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        
        release.add(cnt);
        
        int[] answer = release.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}