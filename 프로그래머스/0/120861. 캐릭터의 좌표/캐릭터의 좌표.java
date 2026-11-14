import java.util.*;

class Solution {
    int r,c;
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    
    boolean inRange(int x, int y){
        return !(x<-r || x>r || y<-c || y>c);
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        r = board[1]/2;
        c = board[0]/2;
        
        Map<String,Integer> moveMap = new HashMap<>();
        
        moveMap.put("right",0);
        moveMap.put("left",1);
        moveMap.put("up",2);
        moveMap.put("down",3);

        int[] move = Arrays.stream(keyinput).mapToInt((k)->moveMap.get(k)).toArray();
        
        int x = 0;
        int y = 0;
        int nx,ny;
        
        for(int m : move){
            nx = x+dx[m];
            ny = y+dy[m];
            
            if(inRange(nx,ny)){
                x = nx;
                y = ny;
            }
        }
        
        
        return new int[]{y, x};
    }
}