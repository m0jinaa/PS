import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n][k + 1];

		int[][] spot = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			spot[i][0] = Integer.parseInt(st.nextToken());
			spot[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j >= i)
					break;

				for (int w = 0; w <= k && w <= j; w++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - w - 1][j - w] + Math.abs(spot[i - w - 1][0] - spot[i][0])
							+ Math.abs(spot[i - w - 1][1] - spot[i][1]));
				}
			}
		}

		int answer = INF;

		for (int i = 0; i <= k; i++) {
			answer = Math.min(answer, dp[n - 1][i]);
		}

		System.out.println(answer);
	}
}