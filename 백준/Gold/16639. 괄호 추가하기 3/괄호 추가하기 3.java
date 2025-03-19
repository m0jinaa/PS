import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[][][] dp;
	static int n, m;
	static int[] nums;
	static char[] operators;

	static void getValue(int s, int e) {

		dp[s][e][0] = Long.MAX_VALUE;
		dp[s][e][1] = Long.MIN_VALUE;

		long[] l, r;

		for (int mid = s; mid < e; mid++) {
			l = dp[s][mid];
			r = dp[mid + 1][e];

			switch (operators[mid]) {
			case '+':
				dp[s][e][0] = Math.min(dp[s][e][0], l[0] + r[0]);
				dp[s][e][1] = Math.max(dp[s][e][1], l[1] + r[1]);
				break;
			case '-':
				dp[s][e][0] = Math.min(dp[s][e][0], l[0] - r[1]);
				dp[s][e][1] = Math.max(dp[s][e][1], l[1] - r[0]);
				break;
			case '*':
				dp[s][e][0] = Math.min(dp[s][e][0], l[0] * r[0]);
				dp[s][e][0] = Math.min(dp[s][e][0], l[0] * r[1]);
				dp[s][e][0] = Math.min(dp[s][e][0], l[1] * r[0]);
				dp[s][e][0] = Math.min(dp[s][e][0], l[1] * r[1]);
				dp[s][e][1] = Math.max(dp[s][e][1], l[0] * r[0]);
				dp[s][e][1] = Math.max(dp[s][e][1], l[0] * r[1]);
				dp[s][e][1] = Math.max(dp[s][e][1], l[1] * r[0]);
				dp[s][e][1] = Math.max(dp[s][e][1], l[1] * r[1]);
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		n = (N + 1) / 2;
		m = N / 2;

		nums = new int[n];
		operators = new char[m];
		dp = new long[n][n][2];

		char[] input = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			if (i % 2 != 0) {
				operators[i / 2] = input[i];
			} else {
				nums[(i + 1) / 2] = input[i] - '0';
				dp[(i + 1) / 2][(i + 1) / 2][0] = input[i] - '0';
				dp[(i + 1) / 2][(i + 1) / 2][1] = input[i] - '0';
			}
		}

		for (int l = 1; l < n; l++) {
			for (int s = 0; s < n - l; s++) {
				getValue(s, s + l);
			}
		}

		System.out.println(dp[0][n - 1][1]);
	}
}