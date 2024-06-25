import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][][] dp = new int[n + 1][2][2];

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine());

			dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
			dp[i][0][1] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + x;
			dp[i][1][0] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
			dp[i][1][1] = dp[i - 1][0][1] + x / 2;
		}

		int answer = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				answer = Math.max(answer, dp[n][i][j]);
			}
		}

		System.out.println(answer);
	}
}