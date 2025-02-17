import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] word = (" " + br.readLine()).toCharArray();

		int n = word.length - 1;

		int[][] dp = new int[n + 1][27];

		final int INF = Integer.MAX_VALUE;

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		int l;

		for (int i = 0; i < n; i++) {
			l = word[i + 1] - 'A' + 1;

			for (int j = 0; j < 27; j++) {
				if (dp[i][j] == INF)
					continue;
				// set
				dp[i + 1][l] = Math.min(dp[i + 1][l], dp[i][j] + 1 + (l == j ? 0 : 1));
				// next
				dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 2);
			}
		}

		int answer = INF;
		for (int i = 0; i < 27; i++) {
			answer = Math.min(answer, dp[n][i]);
		}

		System.out.println(answer);
	}
}