import java.util.*;

class Solution {
    int n;
    int[] identity;
    int[] maxSheep;
    int[] connectedTo;
    
    int check(int v,int sheep, int wolf){
        if(maxSheep[v] != -1){
            return maxSheep[v];
        }

        int max = sheep;
        
        for(int i = 0;i<n;i++){
            //이미 방문한 노드거나 아직 방문할 수 없는 노드인 경우
            if(((1<<i) & v)!=0 || (connectedTo[i] & v) == 0){
                continue;
            }
            
            if(identity[i] == 1){
    
                // 노드에 늑대가 있어서 가면 양이 다 잡아먹히는 경우
                if(sheep<=wolf+1){
                    continue;                    
                }
                else{
                    max = Math.max(max, check(v|(1<<i), sheep, wolf+1));
                }
            }
            else{
                max = Math.max(max, check(v|(1<<i),sheep+1,wolf));
            }
        }
        
        return maxSheep[v] = max;
        
    }
    public int solution(int[] info, int[][] edges) {
        
        n = info.length;
        identity = info;
        maxSheep = new int[1<<n];
        connectedTo = new int[n];
        
        Arrays.fill(maxSheep, -1);
        
        for(int[] edge : edges){
            connectedTo[edge[0]] |= (1<<edge[1]);
            connectedTo[edge[1]] |= (1<<edge[0]);
        }
        
        int answer = check(1,1,0);
        
        return answer;
    }
}