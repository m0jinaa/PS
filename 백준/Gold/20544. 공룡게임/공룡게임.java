import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[][][][] dp = new int[n + 1][2][3][3];

		dp[1][0][0][0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (dp[i][j][k][l] == 0)
							continue;

						if (k != 0 && l != 0) {
							dp[i + 1][j][l][0] = (dp[i + 1][j][l][0] + dp[i][j][k][l]) % MOD;
						} else {
							dp[i + 1][j][l][0] = (dp[i + 1][j][l][0] + dp[i][j][k][l]) % MOD;
							dp[i + 1][j][l][1] = (dp[i + 1][j][l][1] + dp[i][j][k][l]) % MOD;

							if (l != 2)
								dp[i + 1][1][l][2] = (dp[i + 1][1][l][2] + dp[i][j][k][l]) % MOD;
						}
					}
				}
			}
		}

		long answer = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				answer = (answer + dp[n][1][i][j]) % MOD;
			}
		}

		System.out.println(answer);
	}
}