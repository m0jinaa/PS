class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        int n = board.length;
        int m = board[0].length;
        
        int answer = 0;
        
        int x,y;
        
        for(int i = 0;i<4;i++){
            x = h+dx[i];
            y = w+dy[i];
            
            if(x<0 || x>=n || y<0 || y>=m){
                continue;
            }
            else if(board[x][y].equals(board[h][w])){
                answer++;
            }
        }
        
        return answer;
    }
}