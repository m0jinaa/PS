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

		int[][] dp = new int[n + 1][m];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		int x;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				x = Integer.parseInt(st.nextToken());

				for (int k = 0; k < m; k++) {
					if (j == k)
						continue;

					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + x);
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