import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 10007;

		int n = Integer.parseInt(br.readLine());

		int answer = 0;

		int[][] dp = new int[n + 1][n + 1];

		dp[2][1] = 2;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = (2 * dp[i - 1][j] + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
			}
		}

		for (int i = 1; i < n; i++) {
			answer = (answer + dp[n][i]) % MOD;
		}

		System.out.println(answer);
	}
}