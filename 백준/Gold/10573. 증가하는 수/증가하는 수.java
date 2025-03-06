import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX_N = 80;
	static long[][] dp;
	static int l;
	static char[] input;

	static boolean isIncreasing() {
		for (int i = 1; i < l; i++) {
			if (input[i] < input[i - 1])
				return false;
		}
		return true;
	}

	static void init() {
		dp = new long[MAX_N + 2][10];

		Arrays.fill(dp[1], 1);

		for (int i = 1; i <= MAX_N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k >= 0; k--) {
					dp[i + 1][k] += dp[i][j];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int t = Integer.parseInt(br.readLine());

		long answer = 0;

		while (t-- > 0) {
			input = br.readLine().toCharArray();
			l = input.length;

			if (!isIncreasing()) {
				answer = -1;
			} else {
				answer = dp[l + 1][0] - 1;

				for (int i = 0; i < l; i++) {
					for (int j = input[i] - '0' + 1; j < 10; j++) {
						answer -= dp[l - i][j];
					}
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}