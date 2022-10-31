import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,k;
	static long INF = Long.MIN_VALUE;
	static long[][] dp;
	static int[][] walk,bike;
	public static long getMax(int ind, int t) {
		if(t>k)
			return INF;
		else if(ind==n)
			return 0;
		else if(dp[ind][t]!=-1)
			return dp[ind][t];
		{
			return dp[ind][t] = Math.max(walk[ind][1]+getMax(ind+1,t+walk[ind][0]), bike[ind][1]+getMax(ind+1,t+bike[ind][0]));
		}
	}
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		walk = new int[n][2];
		bike = new int[n][2];
		dp = new long[n+1][k+1];
		for(int i = 0;i<n;i++) {
			st =  new StringTokenizer(br.readLine()," ");
			walk[i][0] = Integer.parseInt(st.nextToken());
			walk[i][1] = Integer.parseInt(st.nextToken());
			bike[i][0] = Integer.parseInt(st.nextToken());
			bike[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i<=n;i++)
			Arrays.fill(dp[i], -1);
		
		System.out.println(getMax(0,0));		
	}
}
