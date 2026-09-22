import java.util.*;

class Solution {
    int n,m;
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    
    class Node{
        int r,b,rx,ry,bx,by,c;
        public Node(int r, int b, int rx, int ry, int bx, int by, int c){
            this.r = r;
            this.b = b;
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.c = c;
        }
    }
    
    boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=m);
    }
    
    public int solution(int[][] maze) {

        n = maze.length;
        m = maze[0].length;
        
        int rx = -1, ry = -1, bx = -1,by = -1;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(maze[i][j]==1){
                    rx = i;
                    ry = j;
                }
                else if(maze[i][j] == 2){
                    bx = i;
                    by = j;
                }
            }
        }
        LinkedList<Node> q = new LinkedList<>();
        
        q.add(new Node(1<<(rx*m+ry),1<<(bx*m+by),rx,ry,bx,by,0));
        
        Node now;
        int nrx,nry,nbx,nby,nr,nb;
        
        int answer = 0;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(maze[now.rx][now.ry] == 3 && maze[now.bx][now.by] == 4){
                answer = now.c;
                break;
            }
            
            for(int i = 0;i<4;i++){
                //자신의 도착칸 도달 시 움직이지 않는 점에 유의
                nrx = now.rx+(maze[now.rx][now.ry] == 3?0:dx[i]);
                nry = now.ry+(maze[now.rx][now.ry] == 3?0:dy[i]);
                
                // 격자판 밖으로 벗어났거나, 벽인 칸이거나, 자신이 방문했던 칸인 경우는 제외
                if(!inRange(nrx,nry) || maze[nrx][nry] == 5 || ((nrx!=now.rx || nry!=now.ry)&&(now.r&(1<<(nrx*m+nry)))!=0)){
                    continue;
                }
                
                nr = now.r|(1<<(nrx*m+nry));
                
                for(int j = 0;j<4;j++){
                    nbx = now.bx+(maze[now.bx][now.by] == 4?0:dx[j]);
                    nby = now.by+(maze[now.bx][now.by] == 4?0:dy[j]);

                    if(!inRange(nbx,nby) || maze[nbx][nby] == 5 || ((nbx!=now.bx || nby!=now.by)&&(now.b&(1<<(nbx*m+nby)))!=0)){
                        continue;
                    }
    
                    nb = now.b|(1<<(nbx*m+nby));
                    
                    //동시에 같은 칸으로 움직였거나, 수레끼리 자리를 바꾼 경우도 제외
                    if((nrx == nbx && nry == nby)||(nrx == now.bx && nry == now.by && nbx == now.rx && nby == now.ry)){
                        continue;
                    }
                    
                    q.add(new Node(nr,nb,nrx,nry,nbx,nby,now.c+1));
                    
                    if(nbx == now.bx && nby == now.by){
                        break;
                    }
                }

                if(nrx == now.rx && nry == now.ry){
                    break;
                }
            }
        }
        
        return answer;
    }
}