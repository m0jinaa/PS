import java.util.*;

class Solution {
    public class Node{
        int x, y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int n,m;
    public char[][] map;
    
    public int[] dx = new int[]{0,0,1,-1};
    public int[] dy = new int[]{1,-1,0,0};
    public boolean[][] v;
    public LinkedList<Node> q;
    
    public boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=m);
    }
    
    public int getIslandSize(int x, int y){
        
        v[x][y] = true;
        q.add(new Node(x,y));
        
        Node now;
        int nx,ny;
        
        int size = map[x][y]-'0';
        
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                if(!inRange(nx,ny) || map[nx][ny] == 'X' || v[nx][ny]){
                    continue;
                }
                
                v[nx][ny] = true;
                q.add(new Node(nx,ny));
                size+=map[nx][ny]-'0';
            }
        }
        
        return size;
    }
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][];
        v = new boolean[n][m];
        q = new LinkedList<>();
    
        LinkedList<Integer> islands = new LinkedList<>();
        
        for(int i = 0;i<n;i++){
            map[i] = maps[i].toCharArray();    
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(map[i][j] !='X' && !v[i][j]){
                    islands.add(getIslandSize(i,j));
                }
            }
        }
        
        int l = islands.size();
        int[] answer;
        
        if(l == 0){
            answer = new int[]{-1};
        }
        else{
            answer = new int[l];

            for(int i = 0;i<l;i++){
                answer[i] = islands.poll();
            }

            Arrays.sort(answer);
        }
        
        return answer;
    }
}