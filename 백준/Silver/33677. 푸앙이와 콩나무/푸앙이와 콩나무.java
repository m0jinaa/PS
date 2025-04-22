import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int INF = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		Arrays.fill(dp, INF);

		dp[0] = 0;

		int day = 0;

		while (dp[n] == INF) {
			day++;
			for (int j = n; j >= 0; j--) {
				if (dp[j] == INF)
					continue;

				dp[j + 1] = Math.min(dp[j + 1], dp[j] + 1);

				if (3 * j <= n) {
					dp[3 * j] = Math.min(dp[3 * j], dp[j] + 3);
				}

				if (j <= 1000 && j * j <= n) {
					dp[j * j] = Math.min(dp[j * j], dp[j] + 5);
				}
			}
		}

		sb.append(day).append(" ").append(dp[n]);

		System.out.println(sb.toString());
	}
}