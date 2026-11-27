import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][2];

        int[] S = new int[n];

        
        for(int i = 0;i<n;i++){
            S[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = S[0];
        dp[0][1] = 0;
        
        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+S[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-S[i]);
        }

        int answer = Math.max(dp[n-1][0],dp[n-1][1]);

        System.out.println(answer);
    }
}