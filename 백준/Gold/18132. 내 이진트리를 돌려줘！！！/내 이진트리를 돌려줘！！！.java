import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_007;
	static final int MAX_N = 5_001;
	static long[] dp;

	static void init() {

		dp = new long[MAX_N + 1];

		dp[0] = 1;

		for (int i = 1; i <= MAX_N; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = (dp[i] + dp[j] * dp[i - j - 1]) % MOD;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		init();

		int T = Integer.parseInt(br.readLine());

		int n;

		while (T-- > 0) {

			n = Integer.parseInt(br.readLine()) + 1;

			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb.toString());
	}
}