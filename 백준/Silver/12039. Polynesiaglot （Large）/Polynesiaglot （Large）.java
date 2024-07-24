import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long[][] dp;

		int tc = Integer.parseInt(br.readLine());

		int c, v, l;

		final int MOD = 1_000_000_007;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			dp = new long[l + 1][2];

			dp[1][0] = c;
			dp[1][1] = v;

			for (int i = 2; i <= l; i++) {
				dp[i][0] = (dp[i - 1][1] * c) % MOD;
				dp[i][1] = (dp[i - 1][0] * v + dp[i - 1][1] * v) % MOD;
			}

			sb.append("Case #").append(t).append(": ").append(dp[l][1]).append("\n");
		}

		System.out.print(sb.toString());
	}
}