import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		final long INF = 1_000_000_000_000_000_001L;
		st = new StringTokenizer(br.readLine(), " ");

		int[] grade = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(grade);
		long[][] dp = new long[2][n + 1];

		Arrays.fill(dp[0], INF);
		Arrays.fill(dp[1], INF);

		dp[0][0] = 0;

		for (int i = 2; i <= n; i++) {
			dp[0][i] = Math.min(dp[0][i], dp[0][i - 2] + grade[i] - grade[i - 1]);
			dp[1][i] = Math.min(dp[1][i], dp[1][i - 2] + grade[i] - grade[i - 1]);
			if (i >= 3) {
				dp[1][i] = Math.min(dp[1][i], dp[0][i - 3] + grade[i] - grade[i - 2]);
			}
		}

		System.out.println(dp[1][n]);
	}
}