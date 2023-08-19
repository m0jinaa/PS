import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][][] dp;

	static int count(int s, int e, int d) {
		if (dp[s][e][d] != -1) {
			return dp[s][e][d];
		}
		int cnt = 0;

		if (d == 1) {
			if (s % 3 == d) {
				cnt += count(s + 1, e, (d + 1) % 3);
			}

			if (e % 3 == d) {
				cnt += count(s, e - 1, (d + 1) % 3);
			}
		} else {
			if (s % 3 != 1) {
				cnt += count(s + 1, e, (d + 1) % 3);
			}

			if (e % 3 != 1) {
				cnt += count(s, e - 1, (d + 1) % 3);
			}

		}

		return dp[s][e][d] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int N = 3 * n;
		dp = new int[N][N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}

			if (i % 3 == 1) {
				dp[i][i][0] = 0;
				dp[i][i][1] = 1;
				dp[i][i][2] = 0;
			} else {
				dp[i][i][0] = 1;
				dp[i][i][1] = 0;
				dp[i][i][2] = 1;
			}
		}

		System.out.println(count(0, N - 1, 0));
	}
}