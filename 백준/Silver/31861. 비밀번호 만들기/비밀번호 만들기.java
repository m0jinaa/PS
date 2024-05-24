import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[m + 1][26];

		Arrays.fill(dp[1], 1);

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < 26; j++) {
				if (n == 0) {
					for (int k = 0; k < j - n; k++) {
						dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % MOD;
					}
				} else {
					for (int k = 0; k <= j - n; k++) {
						dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % MOD;
					}
				}
				for (int k = j + n; k < 26; k++) {
					dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % MOD;
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < 26; i++) {
			answer = (answer + dp[m][i]) % MOD;
		}

		System.out.println(answer);
	}
}