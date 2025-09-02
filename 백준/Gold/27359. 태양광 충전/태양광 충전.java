import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final long INF = Long.MAX_VALUE;

		int t = Integer.parseInt(br.readLine());

		int n, b, c, nc;
		int[] d, p;
		long[] f;

		long[][] dp;
		long answer;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			// 충전량
			p = new int[n];
			// 단위가격
			f = new long[n];
			// 사용량
			d = new int[n];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				f[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}

			dp = new long[n + 1][c + 1];

			for (int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], INF);
			}

			// 초기 상태 적용
			dp[0][b] = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= c; j++) {
					if (dp[i][j] == INF)
						continue;

					// 배터리 사용
					if (j >= d[i]) {
						dp[i + 1][j - d[i]] = Math.min(dp[i + 1][j - d[i]], dp[i][j]);
					}

					// 배터리 충천(전기 사용)
					nc = Math.min(c, j + p[i]);

					dp[i + 1][nc] = Math.min(dp[i + 1][nc], dp[i][j] + d[i] * f[i]);
				}
			}

			answer = INF;

			for (int i = c; i >= b; i--) {
				answer = Math.min(answer, dp[n][i]);
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}