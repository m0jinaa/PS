import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 987_654_321;

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][10];

		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < 10; j++) {

				for (int k = -2; k < 3; k++) {
					if (j + k <= 0 || j + k > 9)
						continue;
					dp[i][j] = (dp[i][j] + dp[i - 1][j + k]) % MOD;
				}

			}
		}

		int answer = 0;

		for (int i = 1; i < 10; i++) {
			answer = (answer + dp[n][i]) % MOD;
		}

		System.out.println(answer);
	}
}