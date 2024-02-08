import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[][] dp;
	static long[] sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long k = Long.parseLong(br.readLine());

		int m = 90;
		dp = new long[2][m + 1];
		sum = new long[m + 1];

		dp[1][1] = 1;
		sum[1] = 1;

		for (int i = 2; i <= m; i++) {
			dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
			dp[1][i] = dp[0][i - 1];

			sum[i] = dp[0][i] + dp[1][i] + sum[i - 1];
		}

		int d = -1;

		for (int i = 1; i <= m; i++) {
			if (k > sum[i])
				continue;
			d = i;
			break;
		}

		while (d-- > 0) {
			if (k > sum[d]) {
				sb.append(1);
				k -= (sum[d] + 1);
			} else {
				sb.append(0);
			}
		}

		System.out.println(sb.toString());
	}
}