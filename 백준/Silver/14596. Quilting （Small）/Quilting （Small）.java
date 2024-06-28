import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] A = new int[n + 1][m];
		int[][] B = new int[n + 1][m];
		int[][] dp = new int[n + 1][m];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = INF;
			}
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.min(j == 0 ? INF : dp[i - 1][j - 1],
						Math.min(dp[i - 1][j], j == m - 1 ? INF : dp[i - 1][j + 1]))
						+ (int) Math.pow(A[i][j] - B[i][j], 2);
			}
		}

		int answer = INF;

		for (int i = 0; i < m; i++) {
			answer = Math.min(answer, dp[n][i]);
		}

		System.out.println(answer);
	}
}