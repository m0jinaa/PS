class Solution {
    public int solution(int[][] board) {
        int[] dx = new int[]{-1,-1,-1,0,0,0,1,1,1};
        int[] dy = new int[]{-1,0,1,-1,0,1,-1,0,1};
        
        int n = board.length;
        
        int answer = n*n;
        
        boolean[][] notSafe = new boolean[n][n];
        
        int x,y;
            
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 0){
                    continue;
                }
                else{
                    for(int k = 0;k<9;k++){
                        x = i+dx[k];
                        y = j+dy[k];
                        
                        if(x<0 || x>=n || y<0 || y>=n || notSafe[x][y]){
                            continue;
                        }
                        notSafe[x][y] = true;
                        answer--;
                    }
                }
            }
        }
        
        return answer;
    }
}