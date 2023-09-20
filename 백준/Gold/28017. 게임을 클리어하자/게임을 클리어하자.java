import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		final int INF = 5000001;
		int[][] nums = new int[n + 1][m];

		int[][] dp = new int[n + 1][m];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < m; k++) {
					if (j == k)
						continue;

					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + nums[i][j]);
				}
			}
		}

		int answer = INF;

		for (int i = 0; i < m; i++) {
			answer = Math.min(answer, dp[n][i]);
		}

		System.out.println(answer);
	}
}