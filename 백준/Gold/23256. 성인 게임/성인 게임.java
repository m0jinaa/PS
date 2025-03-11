import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_N = 1_000_000;
	static final int MOD = 1_000_000_007;
	static long[][] dp;

	static void init() {
		dp = new long[MAX_N + 1][2];

		dp[1][0] = 3;
		dp[1][1] = 4;

		for (int i = 2; i <= MAX_N; i++) {
			dp[i][0] = (3 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
			dp[i][1] = (4 * dp[i - 1][0] + 2 * dp[i - 1][1]) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int T = Integer.parseInt(br.readLine());

		int N;

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			sb.append((dp[N][0] + dp[N][1]) % MOD).append("\n");
		}

		System.out.print(sb.toString());
	}
}