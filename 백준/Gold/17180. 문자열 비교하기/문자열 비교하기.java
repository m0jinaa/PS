import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[] A = (" " + br.readLine()).toCharArray();
		char[] B = (" " + br.readLine()).toCharArray();

		int[][] dp = new int[n + 1][m + 1];

		final int INF = 1_000_000_007;

		Arrays.fill(dp[0], INF);
		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i][0] = INF;
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + Math.abs(A[i] - B[j]);
			}
		}

		System.out.println(dp[n][m]);
	}
}