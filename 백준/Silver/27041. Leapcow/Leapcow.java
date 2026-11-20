import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int e = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[e+1];
        boolean[] cows = new boolean[e+1];

        int x;
        
        for(int i = 0;i<b;i++){
            x = Integer.parseInt(br.readLine());

            cows[x] = true;
        }

        final int INF = 1_000_000_007;
        
        Arrays.fill(dp,INF);

        dp[0] = 0;

        for(int i = 1;i<=e;i++){
            if(cows[i]){
                continue;
            }
            
            for(int j = 1;j<=l && i-j>=0;j++){
                if(cows[i-j] || dp[i-j] == INF){
                    continue;
                }
                
                dp[i] = Math.min(dp[i],dp[i-j]+1);
            }
        }

        System.out.println(dp[e]);
    }
}