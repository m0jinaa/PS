class Solution {
    int n = 10;
    
    boolean inRange(int x, int y){
        return !(x<0 || x>n || y<0 || y>n);
    }
    
    public int solution(String dirs) {
        int answer = 0;
        char[] directions = dirs.toCharArray();
        
        boolean[][][] v = new boolean[n+1][n+1][4];
        
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0,};
        
        int x = 5;
        int y = 5;
        
        int m = directions.length;
        
        int nx,ny,d;
        
        for(int i = 0;i < m;i++){
            switch(directions[i]){
                  case 'L':
                      d = 2;
                      break;
                case 'R':
                    d = 0;
                    break;
                case 'U':
                    d = 3;
                    break;
                default:
                    d = 1;
                    break;
            }  
            
            nx = x+dx[d];
            ny = y+dy[d];
            
            if(!inRange(nx,ny)){
                continue;
            }
            else{
                if(!v[x][y][d] && !v[nx][ny][(d+2)%4]){
                    answer++;
                }
                
                v[x][y][d] = true;
                v[nx][ny][(d+2)%4] = true;
                
                x = nx;
                y = ny;
            }
        }
        
        return answer;
    }
}