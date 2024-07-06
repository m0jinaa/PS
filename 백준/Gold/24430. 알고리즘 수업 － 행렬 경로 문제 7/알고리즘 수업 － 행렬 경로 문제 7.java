import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][n + 1];
		boolean[][] p = new boolean[n + 1][n + 1];
		int[][] cnt = new int[n + 1][n + 1];
		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int m = Integer.parseInt(br.readLine());

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			p[x][y] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i - 1][j] < dp[i][j - 1]) {
					dp[i][j] = dp[i][j - 1] + map[i][j];
					cnt[i][j] = cnt[i][j - 1] + (p[i][j] ? 1 : 0);
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j] + map[i][j];
					cnt[i][j] = cnt[i - 1][j] + (p[i][j] ? 1 : 0);
				} else {
					dp[i][j] = dp[i - 1][j] + map[i][j];
					cnt[i][j] = Math.max(cnt[i - 1][j], cnt[i][j - 1]) + (p[i][j] ? 1 : 0);
				}
			}
		}

		sb.append(dp[n][n]).append(" ").append(cnt[n][n]);

		System.out.println(sb.toString());
	}
}