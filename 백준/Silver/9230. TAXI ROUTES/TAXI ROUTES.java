import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, m, x, y, t;

		boolean[][] blocked;
		int[][] dp;

		t = 1;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			blocked = new boolean[n + 1][m + 1];
			dp = new int[n + 1][m + 1];

			while (true) {
				st = new StringTokenizer(br.readLine(), " ");

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				if (x == 0 && y == 0)
					break;

				blocked[x + 1][y + 1] = true;
			}

			dp[0][1] = 1;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (blocked[i][j])
						continue;
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

			sb.append("Map ").append(t).append(": ").append(dp[n][m]).append("\n");

			t++;
		}

		System.out.print(sb.toString());
	}
}