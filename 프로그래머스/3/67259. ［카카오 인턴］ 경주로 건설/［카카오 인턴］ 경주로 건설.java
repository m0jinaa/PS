import java.util.*;

class Solution {
    int n;
    class Node{
        int d,x,y,c;
        
        public Node(int d, int x, int y, int c){
            this.d = d;
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    
    boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=n);
    }
    
    public int solution(int[][] board) {
        final int INF = 1_000_000_007;
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        n = board.length;
        
        int[][][] cost = new int[2][n][n];
        
        for(int i = 0;i<2;i++){
            for(int j = 0;j<n;j++){
                Arrays.fill(cost[i][j],INF);
            }
        }
        LinkedList<Node> q = new LinkedList<>();
        
        q.add(new Node(0,0,0,0));
        q.add(new Node(1,0,0,0));
        
        cost[0][0][0] = 0;
        cost[1][0][0] = 0;
        
        Node now;
        
        int nd,nx,ny,nc;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(cost[now.d][now.x][now.y]<now.c){
                continue;
            }
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                if(!inRange(nx,ny) || board[nx][ny] == 1){
                    continue;
                }
                nd = i/2;
                nc = now.c+100+(now.d != nd?500:0);
                
                if(cost[nd][nx][ny]<=nc){
                    continue;
                }
                else{
                    cost[nd][nx][ny] = nc;
                    q.add(new Node(nd,nx,ny,nc));
                }
            }
        }
        
        int answer = Math.min(cost[0][n-1][n-1],cost[1][n-1][n-1]);
        
        return answer;
    }
}