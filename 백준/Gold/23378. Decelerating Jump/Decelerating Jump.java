import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final long INF = -4_000_000_000_000L;

		int n = Integer.parseInt(br.readLine());

		long[] points = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			points[i] = Long.parseLong(st.nextToken());
		}

		long[][] dp = new long[n][n + 1];

		Arrays.fill(dp[0], points[0]);

		for (int i = 1; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}

		long answer = INF;

		for (int i = 1; i < n; i++) {

			for (int j = i; j > 0; j--) {
				dp[i][j] = Math.max(dp[i][j + 1], dp[i - j][j] + points[i]);
			}

		}
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}

		System.out.println(answer);
	}
}