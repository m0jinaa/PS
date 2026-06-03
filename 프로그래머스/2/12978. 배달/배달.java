import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        final int INF = 1_000_000_007;
        
        int answer = 0;

        int[][] time = new int[N + 1][N + 1];
        
        //도로 정보 초기화
        for(int i = 1; i <= N; i++){
            Arrays.fill(time[i], INF);
            time[i][i] = 0;
        }
        
        //두 마을을 연결하는 도로가 여러 개 있을 수 있다는 점에 주의할 것
        for(int[] edge : road){
            time[edge[0]][edge[1]] = Math.min(time[edge[0]][edge[1]], edge[2]);
            time[edge[1]][edge[0]] = Math.min(time[edge[1]][edge[0]], edge[2]);
        }
        
        //플로이드 워셜
        for(int c = 1; c <= N; c++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(c == a || a == b || b == c){
                        continue;
                    }
                    else if(time[a][c] == INF || time[c][b] == INF){
                        continue;
                    }
                    
                    time[a][b] = Math.min(time[a][b], time[a][c] + time[c][b]);
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            if(time[1][i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
}