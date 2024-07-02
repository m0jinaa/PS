import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n][5];

		Arrays.fill(dp[0], 1);

		for (int i = 0; i < n - 1; i++) {
			// 굶으면 다음날은 식당 가야함
			for (int j = 1; j < 5; j++) {
				dp[i + 1][j] = dp[i][0];
			}

			// 식당 간 날은 다음날에는 굶거나 이웃하는 식당이 아닌 곳 가야함
			for (int j = 1; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (k != 0 && Math.abs(j - k) <= 1)
						continue;
					dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % MOD;
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < 5; i++) {
			answer = (answer + dp[n - 1][i]) % MOD;
		}

		System.out.println(answer);
	}
}