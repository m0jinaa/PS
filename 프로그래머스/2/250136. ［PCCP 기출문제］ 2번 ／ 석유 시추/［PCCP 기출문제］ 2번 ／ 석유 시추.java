import java.util.*;

class Solution {
    public class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int n,m;
    public int[] oil;
    
    public int[][] map;
    public boolean[][] visited;
    public LinkedList<Node> q;
    
    public int[] dx = new int[]{0,0,1,-1};
    public int[] dy = new int[]{1,-1,0,0};
    
    public boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=m);
    }
    
    public void checkOil(int x, int y){
        int c = 1;
        q.clear();
        q.add(new Node(x,y));
        visited[x][y] = true;
        
        Node now;
        int nx,ny;
        int l = y;
        int r = y;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                if(!inRange(nx,ny) || map[nx][ny] == 0 || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                c++;
                q.add(new Node(nx,ny));
                l = Math.min(l,ny);
                r = Math.max(r,ny);
            }
        }
        
        for(int i = l;i<=r;i++){
            oil[i]+=c;
        }
    }
    
    public int solution(int[][] land) {
        map = land;
        
        //땅 크기 
        n = map.length;
        m = map[0].length;
        
        //방문체크용
        visited = new boolean[n][m];
        
        //bfs용
        q = new LinkedList<>();
        
        //시추관을 뚫으면 얻을 수 있는 석유의 양 저장
        oil = new int[m];
        
        //오일이 있고, 방문 안한 곳일 때 진행
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    checkOil(i,j);
                }
            }
        }
        
        int answer = 0;
        
        //얻을 수 있는 최대 석유 양 
        for(int i = 0;i<m;i++){
            answer = Math.max(answer,oil[i]);
        }
        
        return answer;
    }
}