import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        final int MOD = 1_000_000_007;
        
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][2];

        dp[1][0] = 1L;
        dp[1][1] = 2L;

        for(int i = 2;i<=n;i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (2*(dp[i-1][0]+dp[i-1][1])) % MOD;
        }

        long answer = (dp[n][0]+dp[n][1])%MOD;
    
        System.out.println(answer);
    }
}