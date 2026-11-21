import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        final int INF = 1_000_000_007;
        
        int day = Integer.parseInt(br.readLine());

        int n,c;
        char[] map;
        int[] dp;
        String input;
        for(int d = 1;d<=day;d++){
            sb.append("Day #").append(d).append("\n");

            input = br.readLine();

            sb.append(input).append("\n");
            
            st = new StringTokenizer(input," ");

            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken())+1;

            input = br.readLine();
            
            sb.append(input).append("\n");

            map = input.toCharArray();
            
            dp = new int[n];

            Arrays.fill(dp, INF);

            dp[0] = 0;

            for(int i = 1;i<n;i++){
                if(map[i] == 'X'){
                    continue;
                }
                
                for(int j = 1;j<=c && i>=j;j++){
                    if(map[i-j] == 'X'){
                        continue;
                    }
                    dp[i] = Math.min(dp[i],dp[i-j]+1);
                }
            }

            sb.append(dp[n-1] == INF?0:dp[n-1]).append("\n").append("\n");
        }

        System.out.print(sb.toString());
    }
}