import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n + 1][];

		for (int i = 1; i <= n; i++) {
			map[i] = (" " + br.readLine()).toCharArray();
		}

		int[][] dp = new int[n + 1][m + 1];

		dp[1][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 'X')
					continue;

				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
			}
		}

		System.out.println(dp[n][m]);
	}
}