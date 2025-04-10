import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][][] dp = new int[n + 1][n + 1][2];

		final int INF = -2_000_000_007;

		for (int i = 1; i <= n; i++) {
			dp[0][i][0] = INF;
			dp[0][i][1] = INF;
			dp[i][0][0] = INF;
			dp[i][0][1] = INF;
		}
		dp[0][1][0] = 0;
		dp[1][0][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 0; k < 2; k++) {
					dp[i][j][k] = (dp[i - 1][j][k] == INF && dp[i][j - 1][k] == INF) ? INF
							: Math.max(dp[i][j - 1][k], dp[i - 1][j][k]) + map[i][j];
				}

				if (r == i && c == j) {
					dp[i][j][1] = dp[i][j][0];
					dp[i][j][0] = INF;
				}
			}
		}

		sb.append(dp[n][n][1]).append(" ").append(dp[n][n][0]).append("\n");

		System.out.print(sb.toString());
	}
}