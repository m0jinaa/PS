import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] merchant = new int[m + 1][c + 1];
		int[][] dp = new int[m + 1][c + 1];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= c; j++) {
				merchant[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= c; j++) {

				dp[i][j] = Math.max(dp[i - 1][j], merchant[i][j]);

				for (int k = 1; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + merchant[i][j - k]);
				}
			}
		}

		System.out.println(dp[m][c]);
	}
}