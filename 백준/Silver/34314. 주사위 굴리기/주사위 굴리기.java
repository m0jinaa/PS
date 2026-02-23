import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		int t = Integer.parseInt(br.readLine());

		int g, d, nx;

		long[] dp;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			g = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			dp = new long[g + 1];
			dp[0] = 1;

			for (int i = 0; i < g; i++) {
				if (dp[i] == 0)
					continue;
				for (int j = 1; j <= d && i + j <= g; j++) {
					nx = i + j;

					dp[nx] = (dp[nx] + dp[i]) % MOD;
				}
			}

			sb.append(dp[g]).append("\n");
		}

		System.out.println(sb.toString());
	}
}