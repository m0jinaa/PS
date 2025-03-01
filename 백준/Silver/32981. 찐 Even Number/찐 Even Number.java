import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX_N = 10_000_000;
	static final int MOD = 1_000_000_007;
	static final int X = 5;
	static long[] dp;

	static long pow(int c) {
		if (dp[c] != -1)
			return dp[c];

		long p = pow(c / 2);

		if (c % 2 == 0)
			return dp[c] = (p * p) % MOD;
		else {
			return dp[c] = (X * pow(c - 1)) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());

		int n;

		dp = new long[MAX_N + 1];

		Arrays.fill(dp, -1);

		dp[0] = 1;

		while (q-- > 0) {
			n = Integer.parseInt(br.readLine());

			if (n == 1) {
				sb.append(5).append("\n");
			} else {
				sb.append((4 * pow(n - 1)) % MOD).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}