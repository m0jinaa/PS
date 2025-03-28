import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int MAX_N = 24;
	static int[] dp;

	static void init() {
		dp = new int[MAX_N + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 5;

		for (int i = 3; i <= MAX_N; i++) {
			dp[i] = dp[i - 1] + 4 * dp[i - 2];
			for (int j = 3; j <= i; j++) {
				if (j % 2 == 0) {
					dp[i] += 3 * dp[i - j];
				} else {
					dp[i] += 2 * dp[i - j];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int t = Integer.parseInt(br.readLine());

		int n;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb.toString());
	}
}