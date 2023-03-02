import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int totalA = 0;

        int[] A = new int[n];
        int[] B = new int[n];

        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            totalA+=A[i];
        }
        int[][] dp = new int[n][totalA+1];
        for(int i = 0;i<n;i++)
            Arrays.fill(dp[i], INF);
        dp[0][totalA] = 0;
        dp[0][totalA-A[0]] = B[0];

        for(int i = 0;i<n-1;i++) {
            for(int j = 0;j<=totalA;j++) {
                if(dp[i][j]!=INF) {
                    dp[i+1][j] = dp[i][j];
                    dp[i+1][j-A[i+1]] = Math.min(dp[i+1][j-A[i+1]],dp[i][j]+B[i+1]);
                }
            }
        }

        int answer = INF;

        for(int i = 0;i<=totalA;i++) {
            answer = Math.min(answer, Math.max(i,dp[n-1][i]));
        }

        System.out.println(answer);
    }

}