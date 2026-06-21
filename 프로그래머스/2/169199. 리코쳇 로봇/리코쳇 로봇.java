import java.util.*;

class Solution {
    int n,m;
    class Node{
        int x,y,d;
        
        public Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=m);
    }
    
    public int solution(String[] board) {
        final int INF = 1_000_000_007;
        
        n = board.length;
        m = board[0].length();
        
        char[][] map = new char[n][];
        int[][] v = new int[n][m];
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        int sx = -1;
        int sy = -1;
        int ex = -1;
        int ey = -1;
        
        for(int i = 0;i<n;i++){
            Arrays.fill(v[i],INF);
            
            map[i] = board[i].toCharArray();
            
            for(int j = 0;j<m;j++){
                if(map[i][j] == 'R'){
                    sx = i;
                    sy = j;
                    map[i][j] = '.';
                    break;
                }
                else if(map[i][j] == 'G'){
                    ex = i;
                    ey = j;
                    map[i][j] = '.';
                    break;
                }
            }
        }
        
        LinkedList<Node>q = new LinkedList<>();
        
        q.add(new Node(sx,sy,0));
        v[sx][sy] = 0;
        
        int answer = -1;
        
        Node now;
        int nx,ny;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(now.x == ex && now.y == ey){
                answer = now.d;
                break;
            }
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                while(true){
                    if(!inRange(nx,ny) || map[nx][ny] == 'D'){
                        nx-=dx[i];
                        ny-=dy[i];
                        
                        if(v[nx][ny] == INF){
                            v[nx][ny] = now.d+1;
                            q.add(new Node(nx,ny,now.d+1));
                        }
                        break;
                    }
                    
                    nx+=dx[i];
                    ny+=dy[i];
                }
            }
        }
        return answer;
    }
}