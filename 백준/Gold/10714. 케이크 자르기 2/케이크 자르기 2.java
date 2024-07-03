import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static long[][][] dp;
	static long[] cake;

	static long getMax(int s, int e, int t) {
		if (s == e) {
			if (t == 0)
				return dp[s][e][t] = cake[s];
			else
				return dp[s][e][t] = 0;
		} else if (dp[s][e][t] != -1)
			return dp[s][e][t];

		long ret = 0;

		if (t == 1) {
			if (cake[s] < cake[e]) {
				ret = getMax(s, (e + 1) % n, 1 - t);
			} else if (cake[s] > cake[e]) {
				ret = getMax((s + n - 1) % n, e, 1 - t);
			} else {
				ret = Math.max(getMax((s + n - 1) % n, e, 1 - t), getMax(s, (e + 1) % n, 1 - t));
			}
		} else {
			ret = Math.max(getMax((s + n - 1) % n, e, 1 - t) + cake[s], getMax(s, (e + 1) % n, 1 - t) + cake[e]);
		}

		return dp[s][e][t] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		cake = new long[n];
		dp = new long[n][n][2];
		for (int i = 0; i < n; i++) {
			cake[i] = Long.parseLong(br.readLine());
			for (int j = 0; j < n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		long answer = 0;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, getMax((i - 1 + n) % n, (i + 1) % n, 1) + cake[i]);
		}

		System.out.println(answer);
	}
}