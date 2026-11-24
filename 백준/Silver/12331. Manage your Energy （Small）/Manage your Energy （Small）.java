import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        int n,e,r,ne, answer;
        int[] V;
        
        for(int t = 1;t<=tc;t++){

            st = new StringTokenizer(br.readLine()," ");

            e = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            
            int[][] dp = new int[n+1][e+1];

            V = new int[n+1];

            st = new StringTokenizer(br.readLine()," ");
            
            for(int i = 1;i<=n;i++){
                V[i] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i],-1);
            }

            Arrays.fill(dp[0],-1);

            dp[0][e] = 0;

            for(int i = 0;i<n;i++){
                for(int j = 0;j<=e;j++){
                    if(dp[i][j] == -1){
                        continue;
                    }

                    for(int k = 0;k<=j;k++){
                        ne = Math.min(e,j-k+r);
                        dp[i+1][ne] = Math.max(dp[i+1][ne], dp[i][j]+k*V[i+1]);
                    }
                }
            }

            answer = 0;
            
            for(int i = 0;i<=e;i++){
                answer = Math.max(answer,dp[n][i]);
            }
            
            sb.append("Case #").append(t).append(": ").append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }
}