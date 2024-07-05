import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][2];

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());

			dp[i][0] = dp[i - 1][1];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + x;
		}

		long answer = Math.min(dp[n][0], dp[n][1]);

		System.out.println(answer);
	}
}