import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int MAX = 31;

		int[][] dp = new int[MAX][MAX];

		dp[0][0] = dp[1][0] = dp[1][1] = 1;

		for (int i = 2; i < MAX; i++) {
			dp[i][0] = dp[i][i] = 1;
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		sb.append(2 * dp[2 * n - 1][n]).append(" ").append(n * n);

		System.out.println(sb.toString());
	}
}