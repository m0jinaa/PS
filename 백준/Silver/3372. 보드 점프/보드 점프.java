import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 1 };
	static int[] dy = new int[] { 1, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int d, x, y;

		BigDecimal[][] dp;
		int[][] map;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		dp = new BigDecimal[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = BigDecimal.ZERO;
			}
		}

		dp[0][0] = BigDecimal.ONE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d = map[i][j];
				if (i == 2 && j == 1) {
					d = map[i][j];
				}
				if (d == 0 || dp[i][j].equals(BigDecimal.ZERO))
					continue;

				for (int k = 0; k < 2; k++) {
					x = i + dx[k] * d;
					y = j + dy[k] * d;

					if (!inRange(x, y))
						continue;
					dp[x][y] = dp[x][y].add(dp[i][j]);
				}
			}
		}

		System.out.println(dp[n - 1][n - 1].toPlainString());
	}
}