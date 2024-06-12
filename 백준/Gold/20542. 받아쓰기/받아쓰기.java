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

		char[] A = (" " + br.readLine()).toCharArray();

		char[] B = (" " + br.readLine()).toCharArray();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= m; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A[i] == B[j] || (A[i] == 'i' && (B[j] == 'j' || B[j] == 'l')) || (A[i] == 'v' && B[j] == 'w')) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
				}
			}
		}

		System.out.println(dp[n][m]);
	}
}