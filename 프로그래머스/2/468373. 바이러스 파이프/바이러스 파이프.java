import java.util.*;

class Solution {
    class Node{
        int x,c;
        public Node(int x, int c){
            this.x = x;
            this.c = c;
        }
    }
    int[] pipe;
    ArrayList<Node>[] connectedTo;
    boolean[] infected;
    int start,N,K;
    
    LinkedList<Node> q,nq;
    
    int check(){
        
        Arrays.fill(infected,false);
        q.clear();
        nq.clear();
        
        infected[start] = true;
        q.addAll(connectedTo[start]);
        
        int qsize;
        boolean change = false;
        Node now;
        
        int cnt = 1;
        
        for(int i = 0;i<K;i++){
            
            while(!q.isEmpty()){
                now = q.poll();
                
                if(infected[now.x]){
                    continue;
                }
                else if(now.c == pipe[i]){
                    infected[now.x] = true;
                    cnt++;
                    for(Node nx : connectedTo[now.x]){
                        if(infected[nx.x]){
                            continue;
                        }
                        q.add(nx);
                    }
                }
                else{
                    nq.add(now);
                }
            }
            
            q.addAll(nq);
            nq.clear();
        }
        
        return cnt;
    }
    
    int getMax(int x,int b){
        if(x == K){
            return check();
        }
        else{
            int ret= 0;
            int max = 0;
            
            for(int i = 1;i<=3;i++){
                if(b == i){
                    continue;
                }
                pipe[x] = i;
                ret = getMax(x+1,i);
                max = Math.max(max,ret);
                pipe[x] = 0;
            }
            
            return max;
        }
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        N = n;
        start = infection;
        K = k;
        
        connectedTo = new ArrayList[n+1];
        
        for(int i = 1;i<=N;i++){
            connectedTo[i] = new ArrayList<>();
        }
        
        //파이프 연결 정보
        for(int[] edge : edges){
            connectedTo[edge[0]].add(new Node(edge[1],edge[2]));
            connectedTo[edge[1]].add(new Node(edge[0],edge[2]));
        }
        
        infected = new boolean[n+1];
        q = new LinkedList<>();
        nq = new LinkedList<>();
        pipe = new int[k];
        
        int answer = getMax(0,0);
        
        return answer;
    }
}