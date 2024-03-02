import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][][] dp = new int[n + 1][n + 1][11];
		int x;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				x = Integer.parseInt(st.nextToken());
				for (int k = 1; k < 11; k++) {
					dp[i][j][k] = dp[i - 1][j][k] + dp[i][j - 1][k] - dp[i - 1][j - 1][k];
				}
				dp[i][j][x]++;
			}
		}

		int m = Integer.parseInt(br.readLine());

		int x1, y1, x2, y2, v;

		int cnt;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			cnt = 0;

			for (int i = 1; i < 11; i++) {
				v = dp[x2][y2][i] - dp[x1 - 1][y2][i] - dp[x2][y1 - 1][i] + dp[x1 - 1][y1 - 1][i];

				if (v == 0)
					continue;
				cnt++;
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}