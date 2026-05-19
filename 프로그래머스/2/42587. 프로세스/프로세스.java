import java.util.*;

class Solution {
    class Task{
        int x,p;
        
        public Task(int x, int p){
            this.x = x;
            this.p = p;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        int turn = 0;
        
        LinkedList<Task> tasks = new LinkedList<>();
    
        int n = priorities.length;
        
        for(int i = 0;i<n;i++){
            tasks.add(new Task(i,priorities[i]));
        }
        
        Arrays.sort(priorities);
        
        int ind = n-1;
        
        
        while(ind >= 0){
            while(tasks.peekFirst().p != priorities[ind]){
                tasks.add(tasks.pollFirst());
            }
        
            turn++;
            ind--;
            
            if(tasks.peekFirst().x == location){
                break;
            }
            
            tasks.pollFirst();
            
        }
        
        return turn;
    }
}