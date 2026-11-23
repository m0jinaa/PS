import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] P = new int[n][m];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j<m;j++){
                P[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dp[i][j] = Math.max(i-1<0?0:dp[i-1][j],j-1<0?0:dp[i][j-1])+P[i][j];
            }

            sb.append(dp[i][m-1]).append(" ");
        }

        System.out.println(sb.toString());
    }
}