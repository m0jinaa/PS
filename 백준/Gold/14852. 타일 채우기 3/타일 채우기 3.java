import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][2];
		if (n >= 1) {
			dp[1][0] = 2;
		}
		if (n >= 2) {
			dp[2][0] = 7;
			dp[2][1] = 1;
		}

		for (int i = 3; i <= n; i++) {
			dp[i][1] = (dp[i - 1][1] + dp[i - 3][0]) % MOD;
			dp[i][0] = ((dp[i - 1][0] * 2) % MOD + (dp[i - 2][0] * 3) % MOD + (dp[i][1] * 2) % MOD) % MOD;
		}

		System.out.println(dp[n][0]);
	}
}