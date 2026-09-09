import java.util.*;

class Solution {
    int[] dx = new int[]{0,1,0,-1};
    int[] dy = new int[]{1,0,-1,0};
    char[][] map;
    boolean[][][] v;
    int n,m;
    
    int checkCycle(int x, int y, int d){
        
        int cnt = 0;
        
        while(!v[x][y][d]){
            cnt++;
            
            v[x][y][d] = true;

            x = (x+dx[d]+n)%n;
            y = (y+dy[d]+m)%m;
            
            if(map[x][y] == 'S'){
                d = d;
            }
            else if(map[x][y] == 'R'){
                d = (d+1)%4;
            }
            else{
                d = (d+3)%4;
            }
            
        }
        
        return cnt;
    }
    public int[] solution(String[] grid) {
        
        n = grid.length;
        m = grid[0].length();
        
        map = new char[n][];
        v = new boolean[n][m][4];
        
        for(int i = 0;i<n;i++){
            map[i] = grid[i].toCharArray();
        }
        
        ArrayList<Integer> cycles = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 0;k<4;k++){
                    if(v[i][j][k]){
                        continue;
                    }
                    cycles.add(checkCycle(i,j,k));
                }
            }
        }
        
        Collections.sort(cycles);
        
        int[] answer = cycles.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}