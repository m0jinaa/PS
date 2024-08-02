import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		boolean[][] blocked = new boolean[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];

		int x, y;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			blocked[x][y] = true;
		}

		dp[0][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (blocked[i][j])
					continue;
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		System.out.println(dp[n][m]);
	}
}