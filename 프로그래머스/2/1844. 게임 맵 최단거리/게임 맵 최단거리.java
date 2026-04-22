import java.util.*;

class Solution {
    class Node{
        int x, y, d;
        public Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public int solution(int[][] maps) {
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] v = new boolean[n][m];
        
        LinkedList<Node> q = new LinkedList<>();
        
        q.add(new Node(0,0,1));
        v[0][0] = true;
        
        int answer = -1;
        
        Node now;
        int nx,ny;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(now.x == n-1 && now.y == m-1){
                answer = now.d;
            }
            
            for(int i = 0;i<4;i++){
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || maps[nx][ny] == 0 || v[nx][ny]){
                    continue;
                }
                v[nx][ny] = true;
                q.add(new Node(nx,ny,now.d+1));
            }
        }
        
        return answer;
    }
}