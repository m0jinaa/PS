import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = 300;

		st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][n + 1];
		int[][] candy = new int[n + 1][n + 1];

		int x, y;

		while (c-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			candy[x][y] = m;
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = Math.max(0, Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0))
						+ Math.max(0, candy[i][j] - i - j);
			}
		}

		System.out.println(dp[n][n]);
	}
}