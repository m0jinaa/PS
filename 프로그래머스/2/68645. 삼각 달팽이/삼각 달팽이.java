class Solution {
    int N;
    int[][] map;
    boolean inRange(int x, int y){
        return !(x<0 || x>=N || y<0 || y>x || map[x][y]!=0);
    }
    
    public int[] solution(int n) {
        
        N = n;
        
        int[] dx = new int[]{1,0,-1};
        int[] dy = new int[]{0,1,-1};
        
        map = new int[n][n];
        
        int now = 1;
        
        int x = 0;
        int y = 0;
        
        int ind = 0;
        
        int nx,ny;
        
        int max = n*(n+1)/2;
        
        while(now<=max){

            map[x][y] = now++;
            
            nx = x+dx[ind];
            ny = y+dy[ind];
            
            if(!inRange(nx,ny)){
                ind = (ind+1)%3;
                nx = x+dx[ind];
                ny = y+dy[ind];
            }
            
            x = nx;
            y = ny;
        }
        
        int[] answer = new int[max];   
        
        int index = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                answer[index++] = map[i][j];
            }
        }
        
        return answer;
    }
}