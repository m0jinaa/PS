import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final long INF = 6_000_000_007L;
		String input;

		while ((input = br.readLine()) == null || input.isEmpty())
			;

		int m = Integer.parseInt(input);
		int n;
		long[][] D;
		long[][][] dp;
		long answer;

		while (m-- > 0) {
			while ((input = br.readLine()) == null || input.isEmpty())
				;
			n = Integer.parseInt(input);
			D = new long[n + 1][n + 1];
			dp = new long[n + 1][n + 1][n + 1];

			for (int i = 1; i < n; i++) {

				while ((input = br.readLine()) == null || input.isEmpty())
					;
				st = new StringTokenizer(input, " ");

				for (int j = i + 1; j <= n; j++) {
					D[i][j] = Long.parseLong(st.nextToken());
					D[j][i] = D[i][j];
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					Arrays.fill(dp[i][j], INF);
				}
			}

			dp[1][1][1] = 0;

			for (int i = 1; i < n; i++) {
				for (int j = 1; j <= n; j++) {
					for (int k = 1; k <= n; k++) {
						for (int l = 1; l <= n; l++) {
							if (i != j && i != k && i != l)
								continue;
							else if (dp[j][k][l] == INF)
								continue;

							dp[i + 1][k][l] = Math.min(dp[i + 1][k][l], dp[j][k][l] + D[j][i + 1]);
							dp[j][i + 1][l] = Math.min(dp[j][i + 1][l], dp[j][k][l] + D[k][i + 1]);
							dp[j][k][i + 1] = Math.min(dp[j][k][i + 1], dp[j][k][l] + D[l][i + 1]);
						}
					}
				}
			}

			answer = INF;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					answer = Math.min(answer, dp[n][i][j]);
					answer = Math.min(answer, dp[i][n][j]);
					answer = Math.min(answer, dp[i][j][n]);
				}
			}

			System.out.println(answer);
		}
	}
}