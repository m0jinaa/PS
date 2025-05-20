import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		long[][] dp = new long[x + 1][y + 1];

		dp[0][0] = 1;

		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (i >= 2 && j >= 1)
					dp[i][j] = (dp[i][j] + 3 * dp[i - 2][j - 1]) % MOD;

				if (j >= 3) {
					dp[i][j] = (dp[i][j] + dp[i][j - 3]) % MOD;
				}
			}
		}

		System.out.println(dp[x][y]);
	}
}