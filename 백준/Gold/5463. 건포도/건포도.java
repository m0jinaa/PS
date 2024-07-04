import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] sum;
	static long[][][][] dp;
	static final long INF = Long.MAX_VALUE;

	static long getMin(int sx, int sy, int ex, int ey) {
		if (dp[sx][sy][ex][ey] != -1) {
			return dp[sx][sy][ex][ey];
		}
		else if (sx == ex && sy == ey) {
			return dp[sx][sy][ex][ey] = 0;
		}

		long ret = INF;

		// 가로로 자르기
		for (int nx = sx; nx < ex; nx++) {
			ret = Math.min(ret, getMin(sx, sy, nx, ey) + getMin(nx + 1, sy, ex, ey));
		}

		// 세로로 자르기
		for (int ny = sy; ny < ey; ny++) {
			ret = Math.min(ret, getMin(sx, sy, ex, ny) + getMin(sx, ny + 1, ex, ey));
		}

		ret += +sum[ex][ey] - sum[ex][sy - 1] - sum[sx - 1][ey] + sum[sx - 1][sy - 1];

		return dp[sx][sy][ex][ey] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		sum = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		dp = new long[n + 1][m + 1][n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 1; k <= n; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		long answer = getMin(1, 1, n, m);

		System.out.println(answer);
	}
}