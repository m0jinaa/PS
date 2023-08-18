import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[][] dp = new long[100001][2];

		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 2;
		dp[3][1] = 2;

		for (int i = 4; i < 100001; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0]) % MOD;
		}

		int t = Integer.parseInt(br.readLine());
		int n;
		long odd, even;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			odd = dp[n][1] % MOD;
			even = dp[n][0] % MOD;

			sb.append(odd).append(" ").append(even).append("\n");
		}
		System.out.print(sb.toString());
	}
}