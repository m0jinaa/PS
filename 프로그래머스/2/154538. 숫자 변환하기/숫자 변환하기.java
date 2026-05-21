import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Set<Integer> set = new HashSet<>();
        int time = 0;
        
        LinkedList<Integer> list = new LinkedList<>();
        
        set.add(x);
        list.add(x);

        int qsize;        
        int now,next;
        
        end : while(!list.isEmpty()){
            qsize = list.size();
            while(qsize-->0){
                now = list.poll();        
                if(now == y){
                    answer = time;
                    break end;
                }
                else{
                    if((next = now+n)<=y && !set.contains(next)){
                        set.add(next);
                        list.add(next);
                    }
                    
                    if((next = now*2)<=y && !set.contains(next)){
                        set.add(next);
                        list.add(next);
                    }
                    
                    if((next = now*3)<=y && !set.contains(next)){
                        set.add(next);
                        list.add(next);
                    }
                }
            }
            
            time++;
            
        }
        return answer;
    }
}