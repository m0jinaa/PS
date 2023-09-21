import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, k;
		int[][] gallery;
		final int INF = -1_000_000_007;
		int[][][] dp;
		int answer;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			if (n == 0 && k == 0)
				break;
			gallery = new int[n + 1][2];
			dp = new int[n + 1][k + 1][3];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				gallery[i][0] = Integer.parseInt(st.nextToken());
				gallery[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					Arrays.fill(dp[i][j], INF);
				}
			}

			dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					dp[i][j][2] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + gallery[i][0]
							+ gallery[i][1];
					if (j + 1 <= k) {
						dp[i][j + 1][1] = Math.max(dp[i - 1][j][2], dp[i - 1][j][1]) + gallery[i][0];
						dp[i][j + 1][0] = Math.max(dp[i - 1][j][2], dp[i - 1][j][0]) + gallery[i][1];
					}
				}
			}

			answer = Math.max(dp[n][k][0], Math.max(dp[n][k][1], dp[n][k][2]));

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
