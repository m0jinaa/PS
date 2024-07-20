import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] teacher = new boolean[2 * n + 1][n + 1];

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			teacher[x][y] = true;
		}

		int[][] dp = new int[2 * n + 1][n + 1];

		for (int i = 0; i <= 2 * n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int limit;

		dp[0][0] = 0;

		for (int i = 0; i < 2 * n; i++) {
			limit = i < n ? i : (2 * n - i);
			for (int j = 0; j <= limit; j++) {
				if (dp[i][j] == -1)
					continue;
				// 위로 올라가기
				if (j < n && !teacher[i + 1][j + 1]) {
					dp[i + 1][j + 1] = Math.max(j + 1, Math.max(dp[i + 1][j + 1], dp[i][j]));
				}
				// 아래로 내려가기
				if (j > 0 && !teacher[i + 1][j - 1]) {
					dp[i + 1][j - 1] = Math.max(j - 1, Math.max(dp[i + 1][j - 1], dp[i][j]));
				}
			}
		}

		System.out.println(dp[2 * n][0]);
	}
}