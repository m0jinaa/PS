import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		final int INF = 1_000_000_007;

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[][] dp = new int[t + 1][n];

		Arrays.fill(dp[0], INF);

		dp[0][s] = 0;
		int a, b, w;
		for (int i = 0; i < t; i++) {
			System.arraycopy(dp[i], 0, dp[i + 1], 0, n);

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());

				dp[i + 1][b] = Math.min(dp[i + 1][b], dp[i][a] + w);
				dp[i + 1][a] = Math.min(dp[i + 1][a], dp[i][b] + w);
			}
		}

		int answer = dp[t][e] == INF ? -1 : dp[t][e];

		System.out.println(answer);
	}
}