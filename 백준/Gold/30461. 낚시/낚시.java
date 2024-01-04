import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				if (i > 1 && j > 1)
					dp[i][j] += dp[i - 1][j - 1];
				if (i > 1)
					dp[i][j] += dp[i - 1][j];
				if (i > 2 && j > 1)
					dp[i][j] -= dp[i - 2][j - 1];
				dp[i][j] += Integer.parseInt(st.nextToken());
			}
		}

		int x, y;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sb.append(dp[x][y]).append("\n");
		}

		System.out.println(sb.toString());
	}
}