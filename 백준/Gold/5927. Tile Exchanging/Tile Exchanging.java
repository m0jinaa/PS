import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] tiles;
	static int[][] dp;
	static final int INF = 1_000_000_007;

	static int getMin() {
		dp[0][0] = 0;
		
		int s,c;
		for(int i = 1;i<=n;i++) {
			s = tiles[i]*tiles[i];
			
			//안바꾸고 쓰기
			for(int j = s;j<=m;j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-s]);
			}
			
			//바꾸기
			for(int k = 1;k<=100;k++) {
				s = k*k;
				c = (k-tiles[i])*(k-tiles[i]);
				for(int j = s;j<=m;j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-s]+c);
				}			
			}				
		}
		
		return dp[n][m];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tiles = new int[n+1];
		dp = new int[n+1][m+1];
		
		Arrays.fill(dp[0], INF);
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], INF);
			tiles[i] = Integer.parseInt(br.readLine());
		}	

		int answer = getMin();

		System.out.println(answer == INF ? -1 : answer);
	}
}