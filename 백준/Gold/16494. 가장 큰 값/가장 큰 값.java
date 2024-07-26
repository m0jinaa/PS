import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = -1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n + 1];
		int[] sum = new int[n + 1];

		int[][] dp = new int[n + 1][m + 1];

		st = new StringTokenizer(br.readLine(), " ");

		Arrays.fill(dp[0], INF);

		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + nums[i];
			Arrays.fill(dp[i], INF);
			dp[i][0] = 0;
		}

		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 0; k < i; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sum[i] - sum[k]);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}

		int answer = INF;

		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, dp[i][m]);
		}

		System.out.println(answer);
	}
}