import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;

				dp[i][j] = INF;
			}
		}

		int a, b, c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			dp[a][b] = c;
		}

		for (int h = 1; h <= n; h++) {
			for (int i = 1; i <= n; i++) {
				if (dp[i][h] == INF)
					continue;
				for (int j = 1; j <= n; j++) {
					if (dp[h][j] == INF)
						continue;
					dp[i][j] = Math.min(dp[i][j], dp[i][h] + dp[h][j]);
				}
			}
		}

		int cnt = 0;
		long cost = 0;
		long min;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			min = INF;

			for (int i = 1; i <= k; i++) {
				if (dp[a][i] == INF || dp[i][b] == INF)
					continue;

				min = Math.min(min, dp[a][i] + dp[i][b]);
			}

			if (min == INF)
				continue;

			cnt++;
			cost += min;
		}

		sb.append(cnt).append("\n").append(cost).append("\n");

		System.out.print(sb.toString());
	}
}