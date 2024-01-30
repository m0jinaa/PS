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
		int k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], 1_000_000_007);
			dp[i][1] = i;
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 2; j <= k; j++) {
				for (int m = 1; m <= i; m++) {
					dp[i][j] = Math.min(dp[i][j], Math.max(dp[m - 1][j - 1], dp[i - m][j]) + 1);
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
