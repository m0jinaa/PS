import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = (dp[i] + dp[j] * dp[i - j - 1]) % MOD;
			}
		}

		System.out.println(dp[n]);
	}
}