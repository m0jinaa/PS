class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int now = 1;
        
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        
        int target = n*n;
        
        int x = 0;
        int y = 0;
        int nx,ny;
        
        int d = 0;
        
        while(true){
            
            answer[x][y] = now++;
            
            if(now>target){
                break;
            }
            
            nx = x+dx[d];
            ny = y+dy[d];
            
            while(nx<0 || nx>=n || ny<0 || ny>=n || answer[nx][ny]!=0){
                d = (d+1)%4;
                nx = x+dx[d];
                ny = y+dy[d];
            }
            
            x = nx;
            y = ny;  
        }
        
        return answer;
    }
}