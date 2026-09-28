import java.util.*;

class Solution {
    int M,N;
    
    int[][] map;
    boolean[][] v;
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    
    class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    LinkedList<Node> q;
    
    boolean inRange(int x, int y){
        return !(x<0 || x>=M || y<0 || y>=N);
    }
    
    int getSizeOfArea(int x, int y){
        q.clear();
        q.add(new Node(x,y));
        
        v[x][y] = true;
        
        int cnt = 1;
        
        int nx,ny;
        Node now;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                if(!inRange(nx,ny) || map[nx][ny]!=map[x][y] || v[nx][ny]){
                    continue;
                }
                v[nx][ny] = true;
                cnt++;
                q.add(new Node(nx,ny));
            }
        }
        
        return cnt;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        M = m;
        N = n;
        
        map = new int[M][];
        v = new boolean[M][N];
        q = new LinkedList<>();
        
        for(int i = 0;i<M;i++){
            map[i] = picture[i];
        }
        
        int size;
        
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(map[i][j] == 0 || v[i][j]){
                    continue;
                }
                size = getSizeOfArea(i,j);
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea,size);
            }
        }
        
        int[] answer = new int[2];
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}