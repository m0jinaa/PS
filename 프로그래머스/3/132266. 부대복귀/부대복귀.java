
import java.util.*;

class Solution {
    static ArrayList<Integer>[] canGo;
    static int[] v;
    
    static void connect(int x){
        v[x] = 0;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(x);
        
        int now;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int y : canGo[now]){
                if(v[y] !=-1){
                    continue;
                }
                v[y] = v[now]+1;
                q.add(y);
            }
        }
        
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        canGo = new ArrayList[n+1];
        v = new int[n+1];
        
        for(int i = 1;i<=n;i++){
            canGo[i] = new ArrayList<>();
            v[i] = -1;
        }
        
        for(int[] road : roads){
            canGo[road[0]].add(road[1]);
            canGo[road[1]].add(road[0]);
        }
        
        connect(destination);
        
        int m = sources.length;
        
        int[] answer = new int[m];
        
        for(int i = 0;i<m;i++){
            answer[i] = v[sources[i]];
        }
        
        return answer;
    }
}