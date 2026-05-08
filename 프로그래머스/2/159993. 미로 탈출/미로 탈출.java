import java.util.*;

class Solution {
    int n,m;
    char[][] map;
    boolean[][][] v;
    
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    
    class Node{
        int l,x,y,d;
        
        public Node(int l, int x, int y, int d){
            this.l = l;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=m);
    }
    
    int getShortest(int sx, int sy, int ex, int ey){
        
        LinkedList<Node> q = new LinkedList<>();
        
        q.add(new Node(0,sx,sy,0));
        v[0][sx][sy] = true;
        
        Node now;
        int nx,ny,nl;
        
        int ret = -1;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(now.l == 1 && now.x == ex && now.y == ey){
                ret = now.d;
                break;
            }
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                if(!inRange(nx,ny) || map[nx][ny] == 'X'){
                    continue;
                }
                
                nl = map[nx][ny] == 'L'?1:now.l;
                
                if(v[nl][nx][ny]){
                    continue;
                }
                
                v[nl][nx][ny] = true;
                q.add(new Node(nl,nx,ny, now.d+1));
            }
        }
        
        return ret;
    }
    
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][];
        v = new boolean[2][n][m];
        
        int sx = -1, sy = -1, ex = -1, ey = -1;
        
        //시작 지점과 출구 찾기
        for(int i = 0;i<n;i++){
            map[i] = maps[i].toCharArray();
            for(int j = 0;j<m;j++){
                if(map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
        int answer = getShortest(sx,sy,ex,ey);
        
        return answer;
    }
}