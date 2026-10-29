import java.util.function.Function;

import java.util.Arrays;

class Solution {
    final int INF = 1_000_000_007;
    int n;
    int[] d;
    int[][] bestOption;
    int[][] worstCost;
    
    int fill(int s, int e){
        if(worstCost[s][e] != -1){
            return worstCost[s][e];
        }
        
        int cost;
        int min = INF;
        int left,right;
        int loc = -1;
        
        for(int m = s;m <= e;m++){
            
            left = (s == m) ? 0 : fill(s, m - 1);
            right = (m == e) ? 0 : fill(m + 1, e);
            
            cost = d[m] + Math.max(left,right);
            
            if(cost < min){
                min = cost;
                loc = m;
            }
        }
        
        bestOption[s][e] = loc;
        
        return worstCost[s][e] = min;
        
    }
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        
        int answer = -1;
        
        d = depth;
        n = d.length;
        
        //[s,e] 구간을 살펴볼 때 최소의 비용을 들이기위해 파야하는 곳
        bestOption = new int[n][n];
        
        //[s,e] 구간을 살펴볼 때 드는 최악의 비용
        worstCost = new int[n][n];
        
        for(int i = 0;i < n; i++){
            for(int j = 0;j < n; j++){
                bestOption[i][j] = -1;
                worstCost[i][j] = -1;
            }
            bestOption[i][i] = i;
            worstCost[i][i] = d[i];
        }
        fill(0, n - 1);
        
        int s = 0;
        int e = depth.length - 1;
        
        int ret;
        
        while(s <= e){
            int loc = bestOption[s][e];
            
            ret = excavate.apply(loc+1);
            
            if(ret == 0){
                answer = loc + 1;
                break;
            }
            else if(ret == -1){
                e = loc-1;
            }
            else{
                s = loc+1;
            }
        }
        
        return answer;
        
    }
}