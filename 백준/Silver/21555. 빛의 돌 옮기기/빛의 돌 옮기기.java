import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][2];

		long[][] cost = new long[n + 1][2];

		for (int j = 0; j < 2; j++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= n; i++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][1 - j] + k) + cost[i][j];
			}
		}

		long answer = Math.min(dp[n][0], dp[n][1]);

		System.out.println(answer);
	}
}