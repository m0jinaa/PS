import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	static int n, m;
	static long[][][] dp;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new long[n + 1][m + 1][3];
		map = new char[n + 1][];
		for (int i = 1; i <= n; i++) {
			map[i] = (" " + br.readLine()).toCharArray();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = (dp[i - 1][j][k] + dp[i][j - 1][k] - dp[i - 1][j - 1][k] + MOD) % MOD;
				}

				switch (map[i][j]) {
				case 'E':
					dp[i][j][0] = (dp[i][j][0] + 1) % MOD;
					break;
				case 'S':
					dp[i][j][1] = (dp[i][j][1] + dp[i][j][0]) % MOD;
					break;
				case 'M':
					dp[i][j][2] = (dp[i][j][2] + dp[i][j][1]) % MOD;
					break;
				}
			}
		}

		System.out.println(dp[n][m][2]);
	}
}