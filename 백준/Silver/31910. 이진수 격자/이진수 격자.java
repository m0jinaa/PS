import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][n + 1];

		int x;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				x = Integer.parseInt(st.nextToken());

				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) * 2 + x;
			}
		}

		System.out.println(dp[n][n]);
	}
}