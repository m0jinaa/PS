import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MOD = 1_000_000_007;
	static long[][] dp;
	static int MAX_N = 100_000;

	static void init() {
		dp = new long[MAX_N + 1][10];

		Arrays.fill(dp[1], 1);

		for (int i = 1; i < MAX_N; i++) {
			for (int j = 0; j < 10; j++) {
				if (dp[i][j] == 0)
					continue;
				for (int k = j; k < 10; k++) {
					dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % MOD;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int t = Integer.parseInt(br.readLine());

		int n;
		long answer;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			answer = 0;

			for (int i = 0; i < 10; i++) {
				answer = (answer + dp[n][i]) % MOD;
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
