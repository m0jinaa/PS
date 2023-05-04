import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];

        int[] d = new int[n+1];

        for(int i = 1;i<=n;i++) {
            d[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1;i<=n;i++) {
            for(int j = 0;j<=m;j++) {
            	if(j>i)
            		break;
            	if(j==0) {
            		int k = 1;
            		while(i-k>=0 && j+k<=m) {
            			dp[i][j] = Math.max(dp[i-k][j+k], dp[i][j]);
            			k++;
            		}
            		dp[i][j] = Math.max(dp[i][j], dp[i-1][0]);
            	}
            	else{
            		dp[i][j] = dp[i-1][j-1]+d[i];
            	}
            	
            }
        }

        System.out.println(dp[n][0]);
    }
}