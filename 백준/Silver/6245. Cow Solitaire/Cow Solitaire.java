import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];
		char c;

		for (int j = n; j > 0; j--) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= n; i++) {
				c = st.nextToken().charAt(0);
				switch (c) {
				case 'T':
					map[i][j] = 10;
					break;
				case 'A':
					map[i][j] = 1;
					break;
				case 'J':
					map[i][j] = 11;
					break;
				case 'Q':
					map[i][j] = 12;
					break;
				case 'K':
					map[i][j] = 13;
					break;
				default:
					map[i][j] = c - '0';
					break;
				}
			}
		}

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
			}
		}

		System.out.println(dp[n][n]);
	}
}