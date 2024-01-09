import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MOD = 987_654_321;
	static long getCnt(int n) {
		long[] dp = new long[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int x = 0, y = i - 1; x <= y; x++, y--) {
				if (x == y)
					dp[i] = (dp[i] + dp[x] * dp[y]) % MOD;
				else
					dp[i] = (dp[i] + 2 * dp[x] * dp[y]) % MOD;
			}
		}

		return dp[n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(getCnt(n / 2));
	}
}