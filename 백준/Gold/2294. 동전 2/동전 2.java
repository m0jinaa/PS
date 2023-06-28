import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[2][k + 1];
		int ind = 0;
		int INF = 1_000_000_007;
		Arrays.fill(dp[0], INF);
		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			ind = i % 2;
			for (int j = 0; j <= k; j++) {
				if (coins[i] > j) {
					dp[ind][j] = dp[1 - ind][j];
				} else {
					dp[ind][j] = Math.min(dp[ind][j - coins[i]] + 1,
							Math.min(dp[1 - ind][j - coins[i]] + 1, dp[1 - ind][j]));
				}
			}
		}

		if (dp[ind][k] == INF)
			System.out.println(-1);
		else
			System.out.println(dp[ind][k]);
	}
}