import java.util.*;

class Solution {
    final int INF = -1_000_000_007;
    
    int N;
    int[] column;
    
    boolean check(int x, int y){
        for(int i = 0;i<N;i++){
            if(column[i] == y || x-i == Math.abs(y-column[i])){
                return false;
            }
        }
        
        return true;
    }
    int place(int x){
        if(x == N){
            return 1;
        }
        else{
            int cnt = 0;
            
            for(int i = 0;i<N;i++){
                if(check(x,i)){
                    column[x] = i;
                    cnt+=place(x+1);
                    column[x] = INF;
                }
            }
            
            return cnt;
        }
     }
    
    public int solution(int n) {
        N = n;
        column = new int[n];
        Arrays.fill(column,INF);
        
        int answer = place(0);
        
        return answer;
    }
}