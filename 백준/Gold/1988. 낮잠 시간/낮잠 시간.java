import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, b;
		int[] recovery;
		int[][][] dp;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		recovery = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			recovery[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[n + 1][b + 1][2];

		int m;

		for (int i = 1; i <= n; i++) {

			m = Math.min(i, b);

			for (int j = 2; j <= m; j++) {

				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);

				dp[i][j][1] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1] + recovery[i]);
			}
		}

		int answer = Math.max(dp[n][b][0], dp[n][b][1]);

		System.out.println(answer);
	}
}