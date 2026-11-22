import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[5][n+1];

        int limit = (int)Math.sqrt(n);

        dp[0][0] = 1;
        
        for(int i = 0;i<4;i++){
            for(int j = 0;j<=n;j++){
                if(dp[i][j] == 0){
                    continue;
                }

                for(int k = 0;k<=limit;k++){
                    if(j+k*k>n){
                        continue;
                    }
                    dp[i+1][j+k*k]+=dp[i][j];
                }
            }    
        }        

        System.out.print(dp[4][n]);
    }
}