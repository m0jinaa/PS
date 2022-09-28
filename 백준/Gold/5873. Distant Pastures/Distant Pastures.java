import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,A,B;
	static char[][] map;
	static int[][] dp;
	static int[] dx = {0,0,1,-1},dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new char[n][];
		dp = new int[n*n][n*n];
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0;i<n*n;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i = 0;i<n;i++) {
			dp[i][i] = 0;
		}
		int answer = 0;
		
	    for(int i=0; i<n; i++)
	        for(int j=0; j<n-1; j++) {
	            if(map[i][j] == map[i][j+1]) dp[i*n+j][i*n+j+1] = dp[i*n+j+1][i*n+j] = A;
	            else dp[i*n+j][i*n+j+1] = dp[i*n+j+1][i*n+j] = B;
	        }		
	    for(int i=0; i<n-1; i++)
	        for(int j=0; j<n; j++) {
	            if(map[i][j] == map[i+1][j]) dp[i*n+j][(i+1)*n+j] = dp[(i+1)*n+j][i*n+j] = A;
	            else dp[i*n+j][(i+1)*n+j] = dp[(i+1)*n+j][i*n+j] = B;
	        }

	    for(int k=0; k<n*n; k++)
	        for(int i=0; i<n*n; i++)
	            for(int j=0; j<n*n; j++)
	                if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
	                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);

	    for(int i=0; i<n*n; i++)
	        for(int j=i+1; j<n*n; j++)
	            if(dp[i][j] != Integer.MAX_VALUE) answer = Math.max(answer, dp[i][j]);		System.out.println(answer);
	}
}