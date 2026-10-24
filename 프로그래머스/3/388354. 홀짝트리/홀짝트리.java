import java.util.*;

class Solution {
    int[] node;
    int[][] cnt;
    ArrayList<Integer>[] connectedTo;
    boolean[] v;
    
    public int check(int x){
        cnt[node[x]%2][connectedTo[x].size()%2]++;
        
        int c = 1;
        
        for(int nx : connectedTo[x]){
            if(v[nx]){
                continue;
            }
            v[nx] = true;
            c+=check(nx);
        }
        
        return c;
    }
    
    public int[] solution(int[] nodes, int[][] edges) {
        int normal = 0;
        int reverse = 0;
        
        Map<Integer,Integer> indMap = new HashMap<>();
        
        cnt = new int[2][2];
        node = nodes;
        
        int n = nodes.length;
        
        v = new boolean[n];
        connectedTo = new ArrayList[n];
        
        for(int i = 0;i<n;i++){
            indMap.put(nodes[i],i);    
            connectedTo[i] = new ArrayList<>();
        }
        
        int a,b;
        
        for(int[] edge: edges){
            a = indMap.get(edge[0]);
            b = indMap.get(edge[1]);
            
            connectedTo[a].add(b);
            connectedTo[b].add(a);
        }
        
        int total;
        
        for(int i = 0;i<n;i++){
            if(v[i]){
                continue;
            }
            v[i] = true;
            cnt[0][0] = cnt[0][1] = cnt[1][1] = cnt[1][0] = 0;
            total = check(i);
            
            //홀짝트리,역홀짝트리 개수 확인
            
            if(cnt[0][0] == 1 && cnt[1][1] == 0){
                normal++;
            }
            
            if(cnt[0][1] == 1 && cnt[1][0] == 0){
                reverse++;
            }
            
            if(cnt[1][0] == 1 && cnt[0][1] == 0){
                reverse++;
            }
            
            if(cnt[1][1] == 1 && cnt[0][0] == 0){
                normal++;
            }
        }
        
        return new int[]{normal, reverse};
    }
}