import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_007;
	static final int MAX_N = 4000;
	static long[] dp;

	static void init() {
		dp = new long[MAX_N + 1];

		dp[1] = 3;

		for (int i = 2; i <= MAX_N; i++) {
			dp[i] = (dp[i - 1] * 3) % MOD;
			for (int j = 2; j < i; j++) {
				dp[i] = (dp[i] + 2 * j * dp[i - j]) % MOD;
			}
			dp[i] = (dp[i] + 2 * i) % MOD;
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
			if (N % 3 != 0) {
				sb.append(0).append("\n");
			} else {
				sb.append(dp[N / 3]).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}