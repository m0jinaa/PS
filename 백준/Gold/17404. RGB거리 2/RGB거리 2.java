import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[][][] dp;
	static int[][] price;
	static int INF = 1000*1000+1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		price = new int[n][3];
		dp = new int[n][3][3];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<3;j++) {
				Arrays.fill(dp[i][j], INF);
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 3; i++) {
			dp[0][i][i] = price[0][i]; 
		}
		int v;
		for(int i = 1;i<n;i++) {
			for(int j = 0;j<3;j++) {
				v = Math.min(dp[i-1][1][j], dp[i-1][2][j]);
				if(v!=INF)
					dp[i][0][j] = v+price[i][0];
				v = Math.min(dp[i-1][0][j], dp[i-1][2][j]);
				if(v!=INF)
					dp[i][1][j] = v+price[i][1];
				v = Math.min(dp[i-1][0][j], dp[i-1][1][j]);
				if(v!=INF)
					dp[i][2][j] = v+price[i][2];
			}
		}
		
		int answer = INF;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(i==j)
					continue;
				answer = answer>dp[n-1][i][j]?dp[n-1][i][j]:answer;
			}
		}
		System.out.println(answer);
	}
}