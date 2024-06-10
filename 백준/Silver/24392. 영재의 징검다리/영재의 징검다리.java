import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][m];

		int[][] map = new int[n + 1][m];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			if (map[1][i] == 0)
				continue;
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					continue;

				if (j - 1 >= 0)
					dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;

				dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;

				if (j + 1 < m)
					dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
			}
		}

		long answer = 0;

		for (int i = 0; i < m; i++) {
			if (map[n][i] == 0)
				continue;
			answer = (answer + dp[n][i]) % MOD;
		}

		System.out.println(answer);
	}
}