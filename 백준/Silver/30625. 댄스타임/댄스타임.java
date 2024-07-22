import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][2];

		dp[0][0] = 1;

		int a, b;

		final int MOD = 1_000_000_007;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			switch (b) {
			case 0:
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = (dp[i - 1][1] + dp[i - 1][0] * (m - 1)) % MOD;
				break;
			case 1:
				dp[i][0] = (dp[i - 1][0] * (m - 1)) % MOD;
				dp[i][1] = (dp[i - 1][1] * (m - 1) + dp[i - 1][0]) % MOD;
				break;
			}
		}

		long answer = (dp[n][0] + dp[n][1]) % MOD;

		System.out.println(answer);
	}
}