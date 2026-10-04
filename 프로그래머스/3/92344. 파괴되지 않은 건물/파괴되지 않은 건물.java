class Solution {
    public int solution(int[][] board, int[][] skill) {

        int n = board.length;
        int m = board[0].length;
        
        int[][] history = new int[n+1][m+1];
        
        int k = skill.length;
        
        int type,r1,c1,r2,c2,degree;
        
        for(int i = 0;i<k;i++){
            type = skill[i][0];    
            r1 = skill[i][1];    
            c1 = skill[i][2];    
            r2 = skill[i][3];    
            c2 = skill[i][4];    
            degree = skill[i][5];
            
            if(type == 1){
                history[r1][c1]-=degree;
                history[r1][c2+1]+=degree;
                history[r2+1][c1]+=degree;
                history[r2+1][c2+1]-=degree;
            }
            else{
                history[r1][c1]+=degree;
                history[r1][c2+1]-=degree;
                history[r2+1][c1]-=degree;
                history[r2+1][c2+1]+=degree;
            }
        }
        
        for(int i = 0;i<=n;i++){
            for(int j = 1;j<=m;j++){
                history[i][j]+=history[i][j-1];
            }
        }
        
        for(int j = 0;j<=m;j++){
            for(int i = 1;i<=n;i++){
                history[i][j]+=history[i-1][j];
            }
        }
        
        int answer = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]+history[i][j]>0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}