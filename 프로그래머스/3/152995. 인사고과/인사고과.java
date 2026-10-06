import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int n = scores.length;
        
        int wa = scores[0][0];
        int wb = scores[0][1];
        
        Arrays.sort(scores, (x,y)->{
            if(x[0] == y[0]){
                return x[1]-y[1];
            }
            else{
                return y[0]-x[0];
            }
        });
        
        int rank = 1;
        int max = 0;
        
        for(int i = 0;i<n;i++){
            if(max<=scores[i][1]){
                max = scores[i][1];
                if(scores[i][0]+scores[i][1]>wa+wb){
                    rank++;
                }
            }
            else if(scores[i][0] == wa && scores[i][1] == wb){ //완호일 때
                rank = -1;
                break;
            }
        }
        
        return rank;
    }
}