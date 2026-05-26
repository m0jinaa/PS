class Solution {
    int[][] map;
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,1,0,-1};
    
    int rotate(int a, int b, int c, int d){
        
        int temp = map[a][b];
        
        int ret = temp;
        
        int x = a;
        int y = b;
        
        int nx, ny;
        
        int ind = 0;
        
        while(true){
            if((x == c && y == b) || (x == c && y == d)||(x == a && y == d)){
                ind++;
            }
            
            nx = x+dx[ind];
            ny = y+dy[ind];
            
            if(nx == a && ny == b){
                map[x][y] = temp;
                break;
            }
            else{
                map[x][y] = map[nx][ny];
                ret = Math.min(ret,map[nx][ny]);
            }
            
            x = nx;
            y = ny;
        }
        
        return ret;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
    
        map = new int[rows][columns];
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                map[i][j] = i*columns+j+1;
            }
        }
        
        int q = queries.length;
        
        int[] answer = new int[q];
        
        for(int i = 0;i<q;i++){
            answer[i] = rotate(queries[i][0]-1,queries[i][1]-1,queries[i][2]-1, queries[i][3]-1);
        }
        
        return answer;
    }
}