import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][m + 1];

		long INF = Long.MAX_VALUE;

		Arrays.fill(dp[0], INF);
		dp[0][1] = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			dp[i][0] = INF;
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + Integer.parseInt(st.nextToken());
			}
		}

		int h = Integer.parseInt(br.readLine());

		if (h < dp[n][m])
			sb.append("NO");
		else
			sb.append("YES\n").append(dp[n][m]);

		System.out.println(sb.toString());
	}
}