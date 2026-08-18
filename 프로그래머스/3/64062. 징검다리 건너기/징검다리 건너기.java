import java.util.*;

class Solution {
    class Node{
        int x, ind;
        
        public Node(int x, int ind){
            this.x = x;
            this.ind = ind;
        }
    }
    
    public int solution(int[] stones, int k) {
        int answer = 200_000_001;
        
        LinkedList<Node> q = new LinkedList<>();
        
        int n = stones.length;
        
        for(int i = 0;i<n;i++){
            while(!q.isEmpty()){
                if(q.peekFirst().ind<=i+1-k){
                    q.pollFirst();
                }
                else if(q.peekLast().x<stones[i]){
                    q.pollLast();
                }
                else{
                    break;
                }
            }
            
            q.add(new Node(stones[i],i+1));
            
            if(i+1 >= k){
                answer = Math.min(answer,q.peekFirst().x);
            }
        }
        
        return answer;
    }
}