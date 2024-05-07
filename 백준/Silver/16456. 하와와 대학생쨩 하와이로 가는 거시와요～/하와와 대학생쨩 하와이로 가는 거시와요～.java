import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		final int MOD = 1_000_000_009;

		if (n < 3) {
			System.out.println(1);
		} else {
			long[] dp = new long[n + 1];

			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;

			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 3]) % MOD;
			}

			System.out.println(dp[n]);
		}
	}
}