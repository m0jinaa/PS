import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] row = br.readLine().toCharArray();

		int n = row.length;

		int[] dp = new int[n];

		final int INF = 1_000_000_007;

		Arrays.fill(dp, -INF);

		int x;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				dp[i] = (row[i] == '+' ? 10 : 1);
			} else if (i == 1) {
				dp[i] = row[0] == '+' && row[1] == '-' ? 11 : dp[i];
			} else {
				x = row[i] == '+' ? 10 : 1;

				if (row[i - 1] == '+')
					dp[i] = Math.max(dp[i], dp[i - 2] + x);
				else {
					dp[i] = Math.max(dp[i], dp[i - 2] - x);
				}

				if (i > 2 && row[i - 1] == '+' && row[i] == '-') {
					if (row[i - 2] == '+')
						dp[i] = Math.max(dp[i - 3] + 11, dp[i]);
					else
						dp[i] = Math.max(dp[i - 3] - 11, dp[i]);
				}
			}
		}

		System.out.println(dp[n - 1]);
	}
}