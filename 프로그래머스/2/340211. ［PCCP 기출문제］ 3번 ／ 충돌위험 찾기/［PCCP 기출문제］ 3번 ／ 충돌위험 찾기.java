import java.util.*;

class Solution {
    int[][][] map;
    int[][] pointList;
    
    class Point{
        int c, x, y;
        int targetInd;
        int[] targets;
        public Point(int c, int x, int y, int[] targets){
            this.c = c;
            this.x = x;
            this.y = y;
            this.targets = targets;
            this.targetInd = 1;
            
            map[c][x][y]++;
        }
        
        public boolean isCompleted(){
            
            if((this.x == pointList[this.targets[this.targetInd]-1][0]) && (this.y == pointList[this.targets[this.targetInd]-1][1])){
                this.targetInd++;
            }
            
            if(this.targetInd == this.targets.length){
                map[this.c][this.x][this.y]--;
                return true;
            }
            
            return false;
        }
        
        public int move(){
            //현재 위치 표시 제거
            map[this.c][this.x][this.y]--;

            //x 먼저 움직이고 그 다음 y 
            if(this.x < pointList[this.targets[this.targetInd]-1][0]){
                this.x++;
            }
            else if(this.x > pointList[this.targets[this.targetInd]-1][0]){
                this.x--;
            }
            else if(this.y < pointList[this.targets[this.targetInd]-1][1]){
                this.y++;
            }
            else if(this.y > pointList[this.targets[this.targetInd]-1][1]){
                this.y--;
            } 
            
            //움직인 위치 표시
            this.c = 1-this.c;
            
            map[this.c][this.x][this.y]++;
            
            // 처음 겹치는 경우에만 1 리턴
            return map[this.c][this.x][this.y] == 2 ? 1 : 0;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        
        final int MAX = 100;
        
        map = new int[2][MAX+1][MAX+1];
        pointList= points;
        
        int n = points.length;
        int m = routes.length;
        
        int answer = 0;
        
        int a,b;
        
        LinkedList<Point> q = new LinkedList<>();
        
        for(int[] route : routes){
            a = route[0] - 1;
            
            q.add(new Point(0, points[a][0], points[a][1], route));
            
            if(map[0][points[a][0]][points[a][1]] == 2){
                answer++;
            }
        }
        
        Point p;
        
        while(q.size() > 1){
            
            p = q.poll();

            if(!p.isCompleted()){

                answer += p.move();

                q.add(p);
            }
        }

        return answer;
    }
}