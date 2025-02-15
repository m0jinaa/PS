import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static final int MOD = 1_000_000_007;
	static long[][][] dp;

	static void init() {
		N = 10000;
		M = 7;

		dp = new long[N + 1][2][M];
		Arrays.fill(dp[1][0], 1);
		dp[1][0][0] = 0;
		dp[1][0][1] = 2;
		dp[1][0][2] = 2;
		dp[1][1][0] = 1;

		int nj, nl;
		for (int i = 1; i < N; i++) {
			for (int l = 0; l < 2; l++) {
				for (int j = 0; j < M; j++) {
					if (dp[i][l][j] == 0)
						continue;
					for (int k = 0; k < 10; k++) {
						nl = l | (k % 7 == 0 ? 1 : 0);
						nj = (j + k) % M;
						dp[i + 1][nl][nj] = (dp[i + 1][nl][nj] + dp[i][l][j]) % MOD;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int t = Integer.parseInt(br.readLine());

		int n;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			sb.append(dp[n][1][0]).append("\n");
		}

		System.out.println(sb.toString());
	}
}