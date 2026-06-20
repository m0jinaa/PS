class Solution {
    char[][] map;
    int M,N;
    final char EMPTY = ' ';
    int check(){
        int ret = 0;
        
        boolean[][] erased = new boolean[M][N];
        
        for(int i = 0;i+1<M;i++){
            for(int j = 0;j+1<N;j++){
                if(map[i][j] == EMPTY){
                    continue;
                }
                else if(map[i][j] == map[i+1][j] && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j+1]){
                    if(!erased[i][j]){
                        erased[i][j] = true;
                        ret++;
                    }
                    if(!erased[i+1][j]){
                        erased[i+1][j] = true;
                        ret++;
                    }
                    if(!erased[i][j+1]){
                        erased[i][j+1] = true;
                        ret++;
                    }
                    if(!erased[i+1][j+1]){
                        erased[i+1][j+1] = true;
                        ret++;
                    }
                }
            }
        }
        
        
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(erased[i][j]){
                    map[i][j] = EMPTY;
                }
            }
        }
        
        return ret;
    }
    
    void gravity(){
        
        int g;
        
        for(int j = 0;j<N;j++){
            g = 0;
            for(int i = M-1;i>=0;i--){
                if(map[i][j] != EMPTY){
                    if(g == 0){
                        continue;
                    }
                    else{
                        map[i+g][j] = map[i][j];
                        map[i][j] = EMPTY;
                    }
                }   
                else{
                    g++;
                }
            }
        }
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        map = new char[m][];
        M = m;
        N = n;
        
        for(int i = 0;i<m;i++){
            map[i] = board[i].toCharArray();
        }
        
        int ret = 1;
        
        while(ret > 0){
            ret = check();
            
            answer += ret;
            
            if(ret>0){
                gravity();
            }
        }
        
        return answer;
    }
}