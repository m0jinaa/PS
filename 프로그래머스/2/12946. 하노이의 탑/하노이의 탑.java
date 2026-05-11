import java.util.*;

class Solution {
    LinkedList<Move> moving;
    class Move{
        int a,b;
        public Move(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    //원판을 a번 기둥에서 b번 기둥으로 c번 기둥을 활용해서 옮기기
    void move(int x, int a, int b, int c){
        if(x == 1){  //원판이 하나만 남았을 때는 그냥 옮기면 된다.
            moving.add(new Move(a,b));
        }
        else{
            //여러개인 경우에는 하나를 제외한 나머지를 목적지가 아닌 다른 기둥으로 옮기고, 
            move(x-1,a,c,b);
            
            //맨 밑에 있던 원판을 목적지로 옮긴 후
            moving.add(new Move(a,b));
            
            //나머지 원판들을 다시 목적지로 옮긴다.
            move(x-1,c,b,a);    
        }
    }
    public int[][] solution(int n) {
        
        moving = new LinkedList<>();
        
        move(n,1,3,2);
        
        int k = moving.size();
        
        int[][] answer = new int[k][2];
        
        Move m;
        
        for(int i = 0;i<k;i++){
            m = moving.poll();
            answer[i][0] = m.a;
            answer[i][1] = m.b;
        }
        
        return answer;
    }
}