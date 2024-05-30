import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] point = new boolean[n + 1][n + 1];

		int p = Integer.parseInt(br.readLine());

		int r, c;

		while (p-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			point[r][c] = true;
		}

		int[][][] dp = new int[n + 1][n + 1][2];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + map[i][j];

				if (Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) != 0)
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + map[i][j];

				if (point[i][j]) {
					dp[i][j][1] = Math.max(dp[i][j][0], dp[i][j][1]);
				}
			}
		}

		System.out.println(dp[n][n][1]);
	}
}