import java.util.*;

class Solution {
    int N;
    ArrayList<Integer>[] connectedTo;
    boolean[] v;
    int answer = 101;
    
    public int search(int x){
        v[x] = true;
        int c = 1;
        
        int ret;
        
        for(int y : connectedTo[x]){
            if(v[y]){
                continue;
            }
            ret = search(y);
            
            answer = Math.min(answer,Math.abs(N-2*ret));
            
            c+=ret;
        }
        
        return c;
    }
    public int solution(int n, int[][] wires) {
        N = n;
        
        v = new boolean[n+1];
        connectedTo = new ArrayList[n+1];
        
        for(int i = 1;i<=n;i++){
            connectedTo[i] = new ArrayList<>();
        }
        
        for(int[] wire: wires){
            connectedTo[wire[0]].add(wire[1]);
            connectedTo[wire[1]].add(wire[0]);
        }
        
        search(1);
        
        return answer;
        
        
    }
}