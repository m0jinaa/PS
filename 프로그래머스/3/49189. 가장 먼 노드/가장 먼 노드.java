import java.util.*;

class Solution {
    LinkedList<Integer>[] connectedTo;
    int[] dist;
    
    int getFarthestCnt(){
        
        LinkedList<Integer> q = new LinkedList<>();
        
        q.add(1);
        dist[1] = 0;
        
        int farthest = 0;
        int cnt = 1;
        
        int now;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int next : connectedTo[now]){
                if(dist[next] != -1){
                    continue;
                }
                
                dist[next] = dist[now]+1;
                
                if(dist[next] == farthest){
                    cnt++;
                }
                else if(dist[next] > farthest){
                    cnt = 1;
                    farthest = dist[next];
                }
                
                q.add(next);
            }
        }
        
        return cnt;
    }
    public int solution(int n, int[][] edge) {
        
        connectedTo = new LinkedList[n+1];
        dist = new int[n+1];
        
        for(int i = 1;i <= n;i++){
            connectedTo[i] = new LinkedList<>();
            dist[i] = -1;
        }
        
        for(int[] line : edge){
            connectedTo[line[0]].add(line[1]);
            connectedTo[line[1]].add(line[0]);
        }
        
        int answer = getFarthestCnt();
        
        return answer;
    }
}