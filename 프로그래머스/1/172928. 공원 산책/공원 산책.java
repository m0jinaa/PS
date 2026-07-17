import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        Map<Character,Integer> dirMap = new HashMap<>();
        
        dirMap.put('E',0);
        dirMap.put('W',1);
        dirMap.put('S',2);
        dirMap.put('N',3);
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        int n = park.length;
        int m = park[0].length();
        
        char[][] map = new char[n][];
        
        int x = -1,y = -1;
        
        for(int i = 0;i<n;i++){
            map[i] = park[i].toCharArray();
            for(int j = 0;j < m && x == -1;j++){
                if(map[i][j] == 'S'){
                    map[i][j] = 'O';
                    x = i;
                    y = j;
                    break;
                }        
            }
        }
        
        char op;
        int p,d;
        
        int nx,ny;
        boolean possible;
        
        for(String route : routes){
            op = route.charAt(0);
            p = route.charAt(2)-'0';
            
            d = dirMap.get(op);
            
            nx = x;
            ny = y;
            possible = true;
            
            while(p-->0){
                nx+=dx[d];
                ny+=dy[d];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == 'X'){
                    possible = false;
                    break;
                }
                
            }
            
            if(possible){
                x = nx;
                y = ny;
            }
        }
        
        return new int[]{x,y};
    }
}