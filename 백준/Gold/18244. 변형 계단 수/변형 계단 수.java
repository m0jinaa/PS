import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[][][] dp = new long[n + 1][10][5];

		for (int i = 0; i < 10; i++) {
			dp[1][i][0] = 1;
		}

		final int MOD = 1_000_000_007;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 10; j++) {

				if (j < 9) {// 상승 가능
					dp[i + 1][j + 1][1] = ((dp[i][j][0] + dp[i][j][3]) % MOD + dp[i][j][4]) % MOD;
					dp[i + 1][j + 1][2] = dp[i][j][1] % MOD;
				}

				if (j > 0) {// 하강 가능
					dp[i + 1][j - 1][3] = ((dp[i][j][0] + dp[i][j][1]) % MOD + dp[i][j][2]) % MOD;
					dp[i + 1][j - 1][4] = dp[i][j][3] % MOD;
				}
			}
		}

		long answer = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				answer = (answer + dp[n][i][j]) % MOD;
			}
		}

		System.out.println(answer);

	}
}