import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = -1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int a;

		int[][] dp = new int[n + 1][5];

		Arrays.fill(dp[0], INF);

		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			a = Integer.parseInt(st.nextToken());

			Arrays.fill(dp[i], INF);
			dp[i][0] = 0;

			for (int j = 1; j < 5 && j <= i; j++) {
				if (j % 2 != 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - a);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + a);
				}
			}
		}

		System.out.println(dp[n][4]);
	}
}