import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int m = enemy.length;
        
        int answer = m;
        
        for(int i = 0;i < m;i++){
            if(q.size() < k){
                q.add(enemy[i]);
            }
            else if(q.peek() >= enemy[i]){
                if(n >= enemy[i]){
                    n -= enemy[i];
                }
                else{
                    answer = i;
                    break;
                }
            }
            else{
                if(n>=q.peek()){
                    n-=q.poll();
                    q.add(enemy[i]);
                }
                else{
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}