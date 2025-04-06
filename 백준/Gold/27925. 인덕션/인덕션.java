import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[][][][] dp = new int[n + 1][10][10][10];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					Arrays.fill(dp[i][j][k], INF);
				}
			}
		}

		dp[0][0][0][0] = 0;

		int x;
		int d1, d2, d3;

		st = new StringTokenizer(br.readLine(), " ");

		for (int a = 0; a < n; a++) {
			x = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {
						if (dp[a][i][j][k] == INF)
							continue;

						// 1번화구
						d1 = Math.min((x - i + 10) % 10, (i + 10 - x) % 10);
						dp[a + 1][x][j][k] = Math.min(dp[a + 1][x][j][k], dp[a][i][j][k] + d1);

						// 2번화구
						d2 = Math.min((x - j + 10) % 10, (j + 10 - x) % 10);
						dp[a + 1][i][x][k] = Math.min(dp[a + 1][i][x][k], dp[a][i][j][k] + d2);

						// 3번화구
						d3 = Math.min((x - k + 10) % 10, (k + 10 - x) % 10);
						dp[a + 1][i][j][x] = Math.min(dp[a + 1][i][j][x], dp[a][i][j][k] + d3);
					}
				}
			}
		}

		int answer = INF;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (dp[n][i][j][k] == INF)
						continue;
					answer = Math.min(answer, dp[n][i][j][k]);
				}
			}
		}

		System.out.println(answer);
	}
}