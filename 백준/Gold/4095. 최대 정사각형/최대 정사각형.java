import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int answer;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			dp = new int[n + 1][m + 1];
			map = new int[n + 1][m + 1];
			answer = 0;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (map[i][j] == 1) {
						dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					}

					answer = Math.max(answer, dp[i][j]);
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}