class Solution {
    final int D = 5;
    
    boolean inRange(int x, int y){
        return !(x<0 || x>=D || y<0 || y>=D);
    }
    
    public int[] solution(String[][] places) {

        char[][][] map = new char[D][D][];
        
        for(int i = 0;i<D;i++){
            for(int j = 0;j<D;j++){
                map[i][j] = places[i][j].toCharArray();
            }
        }
        
        int[] answer = new int[D];
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        int nx,ny;
        boolean secure;
        int c;
        
        for(int t = 0;t<D;t++){
            secure = true;
            end : for(int i = 0;i<D;i++){
                for(int j = 0;j<D;j++){
                    if(map[t][i][j] == 'X'){
                        continue;
                    }
                    else if(map[t][i][j] == 'P'){
                        for(int k = 0;k<4;k++){
                            nx = i+dx[k];
                            ny = j+dy[k];
                            if(!inRange(nx,ny) || map[t][nx][ny] !='P'){
                                continue;
                            }
                            secure = false;
                            break end;
                        }
                    }
                    else if(map[t][i][j] == 'O'){
                        c = 0;
                        for(int k = 0;k<4;k++){
                            nx = i+dx[k];
                            ny = j+dy[k];
                            if(!inRange(nx,ny) || map[t][nx][ny] !='P'){
                                continue;
                            }
                            c++;
                        }
                        
                        if(c >= 2){
                            secure = false;
                            break end;
                        }
                    }
                }
            }
            
            answer[t] = secure?1:0;
        }
        return answer;
    }
}