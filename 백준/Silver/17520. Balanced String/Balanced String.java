import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][3];
		// dp[n][0]: 1과 0개수 차이 x, dp[n][1] : 1이 하나 더 많음, dp[n][2]: 0이 하나 더 많음.

		dp[1][1] = 1;
		dp[1][2] = 1;

		final int MOD = 16769023;

		for (int i = 1; i < n; i++) {
			dp[i + 1][0] = (dp[i][1] + dp[i][2]) % MOD;
			dp[i + 1][1] = dp[i][0];
			dp[i + 1][2] = dp[i][0];
		}

		int answer = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;

		System.out.println(answer);
	}
}