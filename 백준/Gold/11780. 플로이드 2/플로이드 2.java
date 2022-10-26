import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[][] dp;
	static int[][] bef;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dp = new int[n+1][n+1];
		bef = new int[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			Arrays.fill(dp[i], INF);
			dp[i][i] = 0;
		}
	
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(dp[a][b]>c) {
				dp[a][b] = c;
				bef[a][b] = b;
			}
		}
		
		for(int k = 1;k<=n;k++) {
			for(int i = 1;i<=n;i++) {
				if(k==i)
					continue;
				for(int j = 1;j<=n;j++) {
					if(i==j || j==k)
						continue;
					if(dp[i][j]>dp[i][k]+dp[k][j]) {
						dp[i][j] = dp[i][k]+dp[k][j];
						bef[i][j] = bef[i][k];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder row = new StringBuilder();

		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				sb.append(dp[i][j]==INF?0:dp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		int start,cnt;
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				
				if(i==j || dp[i][j] == INF) {
					sb.append(0).append("\n");
					continue;
				}
				cnt = 1;
				start = i;
				do{
					row.append(start).append(" ");
					cnt++;
				}while((start=bef[start][j])!=j);
				
				sb.append(cnt).append(" ").append(row).append(j).append("\n");
				row.setLength(0);
			}
		}
	
		System.out.println(sb.toString());
	}
}