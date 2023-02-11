import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                Arrays.fill(dp[i][j], INF);
            }
        }
        for (int i = 0; i < m; i++) {
            dp[0][i][0] = map[0][i];
            dp[0][i][1] = map[0][i];
            dp[0][i][2] = map[0][i];
        }
        // 0:왼쪽에서 들어옴, 1: 직선방향, 2: 오른쪽에서 들어옴

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j>0) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+map[i][j];
                }

                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+map[i][j];

                if(j<m-1)
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1])+map[i][j];

            }
        }
        int ans = INF;

        for(int i = 0;i<m;i++) {
            for(int j = 0;j<3;j++) {
                ans = Math.min(ans, dp[n-1][i][j]);
            }
        }

        System.out.println(ans);
    }

}