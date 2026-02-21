import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();

		int n = S.length;

		long[][] dp = new long[n][3];

		long answer = 0;

		int x;

		for (int i = 0; i < n; i++) {
			x = S[i] - '0';
			if (x > 10 || x < 0)
				continue;
			dp[i][x % 3]++;

			if (i > 0) {
				for (int j = 0; j < 3; j++) {
					if (dp[i - 1][j] == 0)
						continue;
					dp[i][(j * 10 + x) % 3] += dp[i - 1][j];
				}
			}

			answer += dp[i][0];
		}

		System.out.println(answer);
	}
}