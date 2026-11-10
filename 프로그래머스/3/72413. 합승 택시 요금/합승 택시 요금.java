import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 1_000_000_007;
        
        int[][] cost = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++){
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
        }
        
        for(int[] fare : fares){
            cost[fare[0]][fare[1]] = cost[fare[1]][fare[0]] = fare[2];
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                if(i == k || cost[i][k] == INF){
                    continue;
                }
                for(int j = 1; j <= n; j++){
                    if(i == j || k == j || cost[k][j] == INF){
                        continue;
                    }
                    
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        
        // 따로 타고 가는 비용
        int answer = cost[s][a]+cost[s][b];
        
        // 합석해서 가는 방법 체크
        for(int i = 1;i <= n; i++){
            if(cost[s][i] == INF || cost[i][a] == INF || cost[i][b] == INF){
                continue;
            }
            answer = Math.min(answer, cost[s][i] + cost[i][a] + cost[i][b]);
        }
        return answer;
    }
}