import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a,b,c,k;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[4][k+1];

        for(int i = 0;i<4;i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for(int j = 0;j<k;j++) {
            for(int i = 0;i<4;i++) {
                if(dp[i][j]==INF)
                    continue;
                if(j+a<=k)
                    dp[(i+3)%4][j+a] = Math.min(dp[i][j]+1,dp[(i+3)%4][j+a]);
                if(j+b<=k)
                    dp[(i+1)%4][j+b] = Math.min(dp[i][j]+1,dp[(i+1)%4][j+b]);
                if(j+c<=k)
                    dp[(i+2)%4][j+c] = Math.min(dp[i][j]+1,dp[(i+2)%4][j+c]);
            }
        }

        System.out.println(dp[0][k]==INF?-1:dp[0][k]);
    }
}