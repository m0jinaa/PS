import java.util.*;

class Solution {
    class Node {
        int x,y,c;
        String p;
        
        public Node(int x, int y, int c, String p){
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] dx = new int[]{1,0,0,-1};
        int[] dy = new int[]{0,-1,1,0};
        char[] dir = new char[]{'d','l','r','u'};
        
        x--;
        y--;
        r--;
        c--;
        
        LinkedList<Node> q = new LinkedList<>();
        
        boolean[][][] v = new boolean[n][m][k+1];
        
        v[x][y][0] = true;
        q.add(new Node(x,y,0,""));
        
        String answer = "impossible";
        
        int nx,ny,nc;
        Node now;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(now.x == r && now.y == c && now.c == k){
                answer = now.p;
                break;
            }
            else if(now.c == k){
                continue;
            }
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                nc = now.c+1;
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || v[nx][ny][nc]){
                    continue;
                }
                
                q.add(new Node(nx,ny,nc,now.p+dir[i]));
                v[nx][ny][nc] = true;
            }
        }
        
        return answer;
 
    }
}