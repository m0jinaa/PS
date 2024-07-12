import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] dp = new int[2][b + 1];

		final int INF = 1_000_000_007;

		Arrays.fill(dp[0], INF);
		Arrays.fill(dp[1], INF);

		dp[0][a] = 0;

		for (int i = a; i < b; i++) {
			for (int j = 0; j < 2; j++) {
				if (dp[j][i] == INF)
					continue;
				if (i < b) {
					dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i] + 1);
				}
				if (i <= b / 2) {
					dp[j][i * 2] = Math.min(dp[j][i * 2], dp[j][i] + 1);
				}
				if (j != 1 && i <= b / 10) {
					dp[1][i * 10] = Math.min(dp[1][i * 10], dp[j][i] + 1);
				}

			}
		}

		int answer = Math.min(dp[0][b], dp[1][b]);

		System.out.println(answer);
	}
}