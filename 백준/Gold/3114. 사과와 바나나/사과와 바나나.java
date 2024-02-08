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

		int[][] apple = new int[n + 1][m + 1];
		int[][] banana = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];

		String fruit;
		int c;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				fruit = st.nextToken();

				banana[i][j] = banana[i - 1][j];
				apple[i][j] = apple[i - 1][j];

				c = Integer.parseInt(fruit.substring(1));

				switch (fruit.charAt(0)) {
				case 'A':
					apple[i][j] += c;
					break;

				case 'B':
					banana[i][j] += c;
					break;
				}
			}
		}

		final int INF = 1_000_000_007;

		for (int i = 1; i <= m; i++) {
			dp[0][i] = -INF;
		}
		for (int i = 1; i <= n; i++) {
			dp[i][0] = -INF;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 위에서 오는 경우
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - (apple[i][j] - apple[i - 1][j]));

				// 옆에서 오는 경우
				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + banana[i - 1][j] + (apple[n][j] - apple[i][j]));

				// 대각선 위에서 오는 경우
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + banana[i - 1][j] + (apple[n][j] - apple[i][j]));
			}
		}
        
		System.out.println(dp[n][m]);
	}
}