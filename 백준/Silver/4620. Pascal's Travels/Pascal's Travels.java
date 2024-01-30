import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		StringBuilder sb = new StringBuilder();
		int d, x, y;
		long[][] dp;
		int[][] map;
		char[] row;
		while ((n = Integer.parseInt(br.readLine())) != -1) {
			map = new int[n][n];
			dp = new long[n][n];
			for (int i = 0; i < n; i++) {
				row = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = row[j] - '0';
				}
			}

			dp[0][0] = 1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					d = map[i][j];
					if (d == 0)
						continue;
					for (int k = 0; k < 2; k++) {
						x = i + dx[k] * d;
						y = j + dy[k] * d;

						if (!inRange(x, y))
							continue;
						dp[x][y] += dp[i][j];
					}
				}
			}

			sb.append(dp[n - 1][n - 1]).append("\n");
		}

		System.out.println(sb.toString());
	}
}