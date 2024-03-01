import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] A, B;
	static int[][] dp;
	static int n, m;

	static int getCnt() {
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + 1));
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = (" " + br.readLine()).toCharArray();
		B = (" " + br.readLine()).toCharArray();

		n = A.length;
		m = B.length;

		dp = new int[n][m];

		int answer = n + m - 2 - getCnt();

		System.out.println(answer);
	}
}