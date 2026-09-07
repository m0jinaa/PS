import java.util.*;

class Solution {
    int[] ret;
    int[] Q;
    int N,M;

    boolean check(int v){
        int c;
        for(int i = 0;i<M;i++){
            
            c = Integer.bitCount((v&Q[i]));
            
            if(ret[i] != c){
                return false;
            }
        }
        
        return true;
    }
    int combi(int c, int x, int v){
        
        if(c == 5){
            if(check(v)){
                return 1;
            } 
            else{
                return 0;
            }
        }
        else{
            int cnt = 0;
            
            for(int j = x;j<=N;j++){
                cnt += combi(c+1,j+1,v+(1<<j));
            }
            
            return cnt;
        }
    }
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        M = q.length;
        Q = new int[M];
        ret = ans;
        
        for(int i = 0;i<M;i++){
            for(int j = 0;j<5;j++){
                Q[i]+=(1<<q[i][j]);
            }    
        }
        
        int answer = combi(0,1,0);
        
        return answer;
    }
}